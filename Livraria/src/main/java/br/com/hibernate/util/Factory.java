package br.com.hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
	static EntityManager   ent ;
	
	
	public static EntityManager getFactory(){
		
		if(ent == null){
	EntityManagerFactory fac = Persistence.createEntityManagerFactory("livraria");	
	
	ent = fac.createEntityManager();
	return ent;
		}else{
		return ent;
			
	}
		
		
	
	}
	
	
	
}
