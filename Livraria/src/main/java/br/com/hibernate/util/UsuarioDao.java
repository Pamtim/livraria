package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.hibernate.Usuario;

public class UsuarioDao {
 EntityManager manger = Factory.getFactory();
	
 public void salvar( Usuario user){
	manger.getTransaction().begin();
	manger.merge(user);
	manger.getTransaction().commit();
 }
 
 @SuppressWarnings("unchecked")
public List<Usuario> lista(){
	 
Query query = manger.createQuery("FROM Usuario e "); 
 return  query.getResultList(); 	
 }
	
 public void excluir(Integer id){
	 Usuario user =manger.find(Usuario.class,id);
	 manger.getTransaction().begin();
	 manger.remove(user);
	 manger.getTransaction().commit(); 
 }
	
 public Usuario busca( String cpf , String senha){

	TypedQuery<Usuario> query = manger.createQuery("From Usuario e where e.funcionario.cpf='"+cpf+"' and e.senha='"+senha+"'",Usuario.class);
  if(query == null){
	  return null;
  }
	
	Usuario user = query.getSingleResult(); 
 return user;
 
 }
 public Usuario buscaUser(Integer id){
 Query query =manger.createQuery("From Usuario where e.id="+id+"");
	return (Usuario)query.getSingleResult(); 
 }
 
 
 
}
