package br.com.Primefaces.Beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class TestBean {
 
	private UploadedFile file;
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public UploadedFile getFile() {
		return file;
	}
	

public void dado(){
	Long tm =file.getSize();
	String nm = file.getFileName();
	System.out.println("Tamanho = "+tm+" Nome :"+nm);
}
	
}
