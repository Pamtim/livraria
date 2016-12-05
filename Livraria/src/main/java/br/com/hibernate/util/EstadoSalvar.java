package br.com.hibernate.util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.com.hibernate.Estado;

public class EstadoSalvar {
	EntityManager manger =Factory.getFactory();
public void inserirEstado(Estado estado) throws PersistenceException{
	manger.getTransaction().begin();
	manger.merge(estado);
	manger.getTransaction().commit();
	
}

public List<Estado> listaEstados(){
Query query = manger.createQuery("FROM Estado e");
List<Estado>estados = query.getResultList();
return estados;
}

public void remove(Integer i){
Estado estado =	manger.find(Estado.class,i);
manger.getTransaction().begin();	
manger.remove(estado);
manger.getTransaction().commit();
}
}

