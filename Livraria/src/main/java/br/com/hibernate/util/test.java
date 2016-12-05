package br.com.hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

public class test {

	public static void main(String[] args) {

try{
EntityManager manger = Factory.getFactory();
}catch(PersistenceException e){
JOptionPane.showMessageDialog(null,"Erro : "+e.getMessage());	

}	
		
	}

}
