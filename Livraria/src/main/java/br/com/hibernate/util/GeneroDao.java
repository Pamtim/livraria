package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Genero;

public class GeneroDao {
EntityManager manger = Factory.getFactory();
	
	
	public void salvar(Genero genero){
		manger.getTransaction().begin();
		manger.merge(genero);
		manger.getTransaction().commit();
		
	}
public void excluir(Integer id){
 Genero genero = manger.find(Genero.class, id);
	manger.getTransaction().begin();
	
	manger.remove(genero);
	manger.getTransaction().commit();
	
}

public List<Genero> lista(){
	Query query = manger.createQuery(" FROM Genero e order by e.nome");
	
	return query.getResultList();
	
}

public List<Genero> busca(String query){
Query  listas = manger.createQuery(" From Genero e where nome like '"+query+"%'");
	
	return listas.getResultList() ;
}


}
