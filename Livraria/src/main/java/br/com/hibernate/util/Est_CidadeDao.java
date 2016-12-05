package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Cidade;

public class Est_CidadeDao {
EntityManager manger = Factory.getFactory();

public List<Cidade> lista(Integer id){
	Query query = manger.createQuery("FROM Cidade cid where cid.estado.id="+id+"");
	
	return query.getResultList();
}
	
	
}
