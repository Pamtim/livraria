package br.com.Primefaces.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.hibernate.Editora;
import br.com.hibernate.util.EditoraDao;

@ManagedBean
@ViewScoped
public class EditoraBean {
private Editora editora;
private List<Editora> editoras;
public List<Editora> getEditoras() {
	return editoras;
}
public void setEditoras(List<Editora> editoras) {
	this.editoras = editoras;
}
public Editora getEditora() {
	return editora;
}
public void setEditora(Editora editora) {
	this.editora = editora;
}


public void novo(){
	editora = new Editora();
	EditoraDao edi = new EditoraDao();
	editoras = edi.lista();
}
public void salvar(){
	try{
	EditoraDao edi = new EditoraDao();
   edi.salvar(editora);
   editoras = edi.lista();
   Messages.addGlobalInfo("Editora Salva com Sucesso!!");
	novo();
	}catch(RuntimeException e){
  e.getStackTrace();
  Messages.addGlobalError("Erro ao salvar editora");
	}

}
	
public void excluir(ActionEvent e){
	editora=(Editora)e.getComponent().getAttributes().get("excluir");
	try{
	EditoraDao edi = new EditoraDao();
	edi.excluir(editora.getId());
	editoras = edi.lista();
	}catch(RuntimeException ex){
		ex.getStackTrace();
	}
}

@PostConstruct
public void lista(){
	try{
	EditoraDao edi = new EditoraDao();
	editoras = edi.lista();
	}catch(RuntimeException e){
	e.getStackTrace();
}
	}


public void editar(ActionEvent e){
	editora = (Editora)e.getComponent().getAttributes().get("editar");
}

	
}
