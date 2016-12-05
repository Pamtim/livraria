package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Funcionario;
import br.com.hibernate.Usuario;

public class FuncionarioDao {
 EntityManager manger = Factory.getFactory();
	
 public void salvar( Funcionario funcionario){
	 manger.getTransaction().begin();
	manger.merge(funcionario);
	manger.getTransaction().commit();
 }
 
 public List<Funcionario> lista(){
	 
	Query query = manger.createQuery("FROM Funcionario e order by e.nome"); 
 return  query.getResultList(); 	
 }
	
 public void excluir(Integer id){
	 Funcionario funcionario =manger.find(Funcionario.class,id);
	 manger.getTransaction().begin();
	 manger.remove(funcionario);
	 manger.getTransaction().commit(); 
 }
 public Funcionario buscaFunc(Integer id){
 Query query =manger.createQuery("From Funcionario e where e.id="+id+"");
	return (Funcionario)query.getSingleResult(); 
 }
	
	
}
