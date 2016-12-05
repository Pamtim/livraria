package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.omnifaces.util.Messages;

import br.com.hibernate.VendaBean;

public class VendaDao {
EntityManager manger = Factory.getFactory();
	
	public void salvar(VendaBean venda){
	try{
		manger.getTransaction().begin();
		manger.merge(venda);
		manger.getTransaction().commit();
	}catch(PersistenceException e){
	Messages.addGlobalError("Erro ao efetivar venda : "+e.getMessage());
     manger.getTransaction().rollback();
	}
	}
	

	
@SuppressWarnings("unchecked")
public List<VendaBean> lista(){
Query query = manger.createQuery("FROM VendaBean e;");
return query.getResultList();
}


}
