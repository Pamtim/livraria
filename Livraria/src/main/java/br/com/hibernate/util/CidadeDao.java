package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Cidade;

public class CidadeDao {
 EntityManager manger = Factory.getFactory();
	
 public void salvar( Cidade cidade){
	 manger.getTransaction().begin();
	manger.merge(cidade);
	manger.getTransaction().commit();
 }
 
 public List<Cidade> lista(){
	 
	Query query = manger.createQuery("FROM Cidade e order by e.nome"); 
 return  query.getResultList(); 	
 }
	
 public void excluir(Integer id){
	 Cidade cidade =manger.find(Cidade.class,id);
	 manger.getTransaction().begin();
	 manger.remove(cidade);
	 manger.getTransaction().commit(); 
 }
	
	
}
