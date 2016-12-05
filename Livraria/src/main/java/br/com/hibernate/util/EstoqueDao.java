package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Estoque;
import br.com.hibernate.Livro;

public class EstoqueDao {
EntityManager manger = Factory.getFactory();

public void salvar(Estoque estoque){
	manger.getTransaction().begin();
	manger.merge(estoque);
	manger.getTransaction().commit();
	
	
}

public void excluir(Integer id ){
Estoque estoque = manger.find(Estoque.class,id);
manger.getTransaction().begin();
manger.remove(estoque);
manger.getTransaction().commit();
}
	
	
	@SuppressWarnings("unchecked")
	public List<Estoque> lista (){
Query query = manger.createQuery("FROM Estoque e ");

return query.getResultList();		
	}
	
	public Estoque busca(Livro livro){
	Query query  = manger.createQuery("From Estoque e where e.livro.id ="+livro.getId()+"");	
	return (Estoque)query.getSingleResult();
	}

}
