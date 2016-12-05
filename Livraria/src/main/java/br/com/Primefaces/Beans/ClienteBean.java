package br.com.Primefaces.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import org.omnifaces.util.Messages;

import br.com.hibernate.Cidade;
import br.com.hibernate.Cliente;
import br.com.hibernate.Estado;
import br.com.hibernate.util.ClienteDao;
import br.com.hibernate.util.Est_CidadeDao;
import br.com.hibernate.util.EstadoSalvar;
import br.com.hibernate.util.Factory;

@ManagedBean
@ViewScoped
public class ClienteBean {
private int idCidade;
private int idEstado;
private Cliente cliente ;
public void setIdCidade(int idCidade) {
	this.idCidade = idCidade;
}
public void setIdEstado(int idEstado) {
	this.idEstado = idEstado;
}
public int getIdCidade() {
	return idCidade;
}
public int getIdEstado() {
	return idEstado;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Cidade getCidade() {
	return cidade;
}
public void setCidade(Cidade cidade) {
	this.cidade = cidade;
}
public Estado getEstado() {
	return estado;
}
public void setEstado(Estado estado) {
	this.estado = estado;
}
public List<Cidade> getCidades() {
	return cidades;
}
public void setCidades(List<Cidade> cidades) {
	this.cidades = cidades;
}
public List<Estado> getEstados() {
	return estados;
}
public void setEstados(List<Estado> estados) {
	this.estados = estados;
}
private Cidade cidade ;
private Estado estado ;
private List<Cidade> cidades ;
private List<Estado> estados;
	

// Metodos de Ação 

public void novo(){
	cliente = new Cliente ();
	EstadoSalvar est = new EstadoSalvar();
	estados = est.listaEstados();
	cidades = new ArrayList<Cidade>();
}

@PostConstruct
public void Inicio(){
	novo();		
}
public void Salvar(){
try{
EntityManager manger = Factory.getFactory();
Cidade cidade =manger.find(Cidade.class,idCidade);
cliente.setCidade(cidade);
ClienteDao cli = new ClienteDao();	
cli.salvar(cliente);
novo();
idEstado = (Integer) null;
Messages.addGlobalInfo("Cadastro Efetuado com sucesso");
}catch(RuntimeException e){
Messages.addGlobalError("Erro ao Salvar Cliente");
e.getStackTrace();
}


}
public void dados_cidade(){
try{
Est_CidadeDao cid = new Est_CidadeDao();
cidades = cid.lista(idEstado);
	}catch(RuntimeException e){
		Messages.addGlobalError("Erro ao Lista Cidade");
		e.getStackTrace();
	}
	}
	
}
