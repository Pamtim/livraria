package br.com.Primefaces.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

import br.com.hibernate.Estado;
import br.com.hibernate.util.EstadoSalvar;
@ManagedBean
@ViewScoped
public class EstadoBean {
private Estado estado ;
private List<Estado>estadoFilter;
public void setEstadoFilter(List<Estado> estadoFilter) {
	this.estadoFilter = estadoFilter;
}
public List<Estado> getEstadoFilter() {
	
	return estadoFilter;
	}
public void setEstado(Estado estado) {
	this.estado = estado;
}
public Estado getEstado() {
	return estado;
}
public void novo(){
	estado = new Estado();
}
private List<Estado> estados ;
public List<Estado> getEstados() {
	return estados;
}
public void setEstados(List<Estado> estados) {
	this.estados = estados;
}
public void salva(){
String msg = "Estado Salvo com Sucesso";
FacesMessage sucesso = new  FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
FacesMessage erro= new  FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
FacesContext  texto = FacesContext.getCurrentInstance();
try{
	EstadoSalvar salva = new EstadoSalvar();
	salva.inserirEstado(estado);
	novo();
	EstadoSalvar estadoda = new EstadoSalvar();	
	estados = estadoda.listaEstados();	
	texto.addMessage(null,sucesso);
}catch(PersistenceException e){
	texto.addMessage(null,erro);
}

}
@PostConstruct
public void tableEstado(){
	try{
EstadoSalvar estado = new EstadoSalvar();	
estados = estado.listaEstados();		
	}catch(RuntimeException erro){		
		erro.printStackTrace();
	}
	}
public void remove(ActionEvent e){
EstadoSalvar rem = new EstadoSalvar();
	Estado estadore = new Estado();
	estadore=(Estado)e.getComponent().getAttributes().get("selecionado");
rem.remove(estadore.getId());
EstadoSalvar lis = new EstadoSalvar();
estados = lis.listaEstados();
}
public void editaAdiciona(ActionEvent e){
estado=(Estado)e.getComponent().getAttributes().get("selecionado");
}
}
