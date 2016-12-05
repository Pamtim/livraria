package br.com.Primefaces.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

import org.omnifaces.util.Messages;

import br.com.hibernate.Autor;
import br.com.hibernate.util.AutorDao;

@ManagedBean
@ViewScoped
public class AutorBean {
private Autor autor ;
public Autor getAutor() {
	return autor;
}
public void setAutor(Autor autor) {
	this.autor = autor;
}
public List<Autor> getAutores() {
	return autores;
}
public void setAutores(List<Autor> autores) {
	this.autores = autores;
}
private List<Autor> autores;

// Metodos de ação 


public void novo(){
autor = new Autor();
	
}
public void salvar(){
	try{
	AutorDao aut = new AutorDao();
	aut.salvar(autor);
	autores = aut.lista();
	novo();
	Messages.addGlobalInfo("Autor Salvo com sucesso!!");
	}catch(PersistenceException  e ){
		Messages.addGlobalError("Erro ao salvar o Autor");
	    e.getStackTrace();
	}
	
	
	
}
	@PostConstruct
	public void lista (){
	try{	
		AutorDao aut = new AutorDao();
		autores = aut.lista();
	}catch(RuntimeException e){
		e.getStackTrace();
		Messages.addGlobalError("Erro ao Lista Autores");
	}
	}


public void excluir(ActionEvent e){
	try{
autor = (Autor)e.getComponent().getAttributes().get("excluir");	
AutorDao aut = new AutorDao();
aut.excluir(autor.getId());
autores = aut.lista();
}catch(PersistenceException ex){
 Messages.addGlobalError("Erro ao Excluir autor!!\n"+ex.getMessage());	
}
	}

public void editar(ActionEvent e){
 
autor = (Autor)e.getComponent().getAttributes().get("editar");	

}

}
