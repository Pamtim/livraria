package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Livro;

public class LivroDao {
	EntityManager manger = Factory.getFactory();


	public void salvar( Livro livro){
		manger.getTransaction().begin();
		manger.merge(livro);
		manger.getTransaction().commit();
	}
		
	
	public void Excluir(Integer id){
	Livro livro =	manger.find(Livro.class, id);
		manger.getTransaction().begin();
		manger.remove(livro);
		manger.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> lista(){
	Query query = manger.createQuery("FROM Livro e");
	return query.getResultList();
	}
	
}
