package br.com.Primefaces.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omnifaces.util.Messages;

import br.com.hibernate.util.Factory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@ManagedBean
public class RelatorioBean {
	public void livro (){
	Connection connection=null;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/livraria","livraria","vitor12");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		try {
			String cm = "C:/Users/Fatima10/Documents/projetoeclipse/Livraria/src/main/webapp/relatorios/produtos.jasper";
		 JasperPrint relatorio =	JasperFillManager.fillReport(cm, null, connection);
		 JasperViewer view = new JasperViewer(relatorio,false);
		 view.setVisible(true);
		 view.toFront();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Messages.addGlobalError("Erro ao gerar relatorio:"+e.getMessage());
		}
		
	}
	
}
