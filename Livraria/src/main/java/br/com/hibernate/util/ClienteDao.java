package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Autor;
import br.com.hibernate.Cliente;

public class ClienteDao {

	EntityManager manger = Factory.getFactory();

	public void salvar(Cliente cliente){
	manger.getTransaction().begin();
	manger.persist(cliente);
	manger.getTransaction().commit();
			
		}

	@SuppressWarnings("unchecked")
	public List<Autor> lista(){
	Query query	=manger.createQuery("FROM Cliente e");
		return query.getResultList();
	}

	public void excluir(Integer id){
	Cliente cliente=manger.find(Cliente.class, id);
		manger.getTransaction().begin();
		manger.remove(cliente);
		manger.getTransaction().commit();
	}
	
@SuppressWarnings("unchecked")
public List<Cliente> listaCli(){
Query query =manger.createQuery("From Cliente e");
return query.getResultList();
}
public Cliente buscaCli(Integer id){
Query query =manger.createQuery("From Cliente e where  e.id="+id+"");
	return (Cliente)query.getSingleResult(); 
}
	
}
