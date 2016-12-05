package br.com.Primefaces.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.omnifaces.util.Messages;

import br.com.hibernate.Cidade;
import br.com.hibernate.Estado;
import br.com.hibernate.util.CidadeDao;
import br.com.hibernate.util.EstadoSalvar;
import br.com.hibernate.util.Factory;

@ManagedBean
@ViewScoped
public class CidadeBean {
private Cidade cidade;
private Integer id ;
private List<Cidade> cidades ;
private List<Estado> estados;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public List<Estado> getEstados() {
	return estados;
}
public void setEstados(List<Estado> estados) {
	this.estados = estados;
}
public List<Cidade> getCidades() {
	return cidades;
}
public void setCidades(List<Cidade> cidades) {
	this.cidades = cidades;
}
public Cidade getCidade() {
	return cidade;
}
public void setCidade(Cidade cidade) {
	this.cidade = cidade;
}

//Metodos de Ação do Prime Faces 


@PostConstruct
public void listaTable(){
CidadeDao lis = new CidadeDao();
cidades = lis.lista();		
}
public void novo(){
try{
cidade= new Cidade();
EstadoSalvar est = new EstadoSalvar();
estados = est.listaEstados();
}catch(Exception e ){
Messages.addGlobalInfo("Erro ao Adiciona uma Nova Cidade\n Erro : "+e.getMessage());
e.getStackTrace();
}
}
//metodo para salvar cidades 
public void salvar(){
try	{
EntityManager manger = Factory.getFactory();
CidadeDao cid = new CidadeDao();
Estado estado = manger.find(Estado.class,id);
cidade.setEstado(estado);
cid.salvar(cidade);
cidades = cid.lista();
EstadoSalvar est = new EstadoSalvar();
estados=est.listaEstados();
Messages.addGlobalInfo("Cidade Cadastrada com sucesso!!");
novo();
}catch(PersistenceException e){
	Messages.addFlashGlobalError("Erro ao Salvar Mensagem \nErro : "+e.getMessage());
	e.getStackTrace();
}
}
//metodo para excluir cidades 
public void excluir(ActionEvent e){
try{ 
cidade=(Cidade) e.getComponent().getAttributes().get("exclusão");
CidadeDao cid = new CidadeDao();
cid.excluir(cidade.getId());
cidades = cid.lista();
}catch(PersistenceException ex){
	Messages.addGlobalInfo("Erro ao Exluir Cidade \nErro: "+ex.getMessage());
}
}

//metodo para editar cidades 	

public void editar(ActionEvent e){
	try{
	cidade=(Cidade)e.getComponent().getAttributes().get("editar");
EstadoSalvar est = new EstadoSalvar();	
	estados = est.listaEstados();
	}catch(RuntimeException ex){
Messages.addGlobalError("Erro ao Editar uma cidade");	
}

}

}
