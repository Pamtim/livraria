package br.com.hibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.Autor;
import br.com.hibernate.Editora;

public class EditoraDao {

	EntityManager manger = Factory.getFactory();

	public void salvar(Editora editora){
	manger.getTransaction().begin();
	manger.merge(editora);
	manger.getTransaction().commit();
			
		}

	public List<Editora> lista(){
	Query query	=manger.createQuery("FROM Editora e");
		return query.getResultList();
	}

	public void excluir(Integer id){
	Editora editora=manger.find(Editora.class, id);
		manger.getTransaction().begin();
		manger.remove(editora);
		manger.getTransaction().commit();
	}
	
}
