package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Autor;

public class AutorDao {
	EntityManager manger = Factory.getFactory();

public void salvar(Autor autor){
manger.getTransaction().begin();
manger.merge(autor);
manger.getTransaction().commit();
		
	}

public List<Autor> lista(){
Query query	=manger.createQuery("FROM Autor e");
	return query.getResultList();
}

public void excluir(Integer id){
Autor autor=manger.find(Autor.class, id);
	manger.getTransaction().begin();
	manger.remove(autor);
	manger.getTransaction().commit();
}

}
