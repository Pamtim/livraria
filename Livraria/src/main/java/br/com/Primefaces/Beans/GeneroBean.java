package br.com.Primefaces.Beans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.hibernate.Genero;
import br.com.hibernate.util.GeneroDao;

@ManagedBean
@ViewScoped
public class GeneroBean {
private Genero genero = new Genero();
public Genero getGenero() {
	return genero;
}
public void setGenero(Genero genero) {
	this.genero = genero;
	
}

private List<Genero> generos;

public List<Genero> getGeneros() {
	return generos;
}
public void setGeneros(List<Genero> generos) {
	this.generos = generos;
}

//Metodos de ação 


public void novo(){
	genero = new Genero();
}

public void salvar(){
	try{
		GeneroDao ge = new GeneroDao();
		ge.salvar(genero);		
		novo();
		generos = ge.lista();
		Messages.addGlobalInfo("Genero Salvo com sucesso!!");
	}catch(RuntimeException e){
		Messages.addGlobalError("Erro ao Salvar o genero!!");
		e.getStackTrace();
	}
	
	
}


public void excluir(ActionEvent e){
try{
	genero=(Genero)e.getComponent().getAttributes().get("excluir");
	GeneroDao ge = new GeneroDao();
ge.excluir(genero.getId());
novo();
 generos = ge.lista();
}catch(RuntimeException ex){
	Messages.addGlobalError("Erro ao Salvar o genero!!");
	ex.getStackTrace();
}
}


@PostConstruct
public void lista(){
	novo();
	GeneroDao ge = new GeneroDao();
	generos =  	ge.lista();
	
}

public void editar(ActionEvent e){
	genero = (Genero) e.getComponent().getAttributes().get("editar");	
}
	
	
	
	
	
}
