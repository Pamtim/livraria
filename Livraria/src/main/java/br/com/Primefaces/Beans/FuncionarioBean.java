package br.com.Primefaces.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.omnifaces.util.Messages;

import br.com.hibernate.Cidade;
import br.com.hibernate.Estado;
import br.com.hibernate.Funcionario;
import br.com.hibernate.util.CidadeDao;
import br.com.hibernate.util.Est_CidadeDao;
import br.com.hibernate.util.EstadoSalvar;
import br.com.hibernate.util.Factory;
import br.com.hibernate.util.FuncionarioDao;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
private Funcionario funcionario;
private List<Estado> estados;
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
public Integer getIdCidade() {
	return idCidade;
}
public void setIdCidade(Integer idCidade) {
	this.idCidade = idCidade;
}
public Integer getIdEstado() {
	return idEstado;
}
public void setIdEstado(Integer idEstado) {
	this.idEstado = idEstado;
}





private List<Cidade> cidades;
private Integer idCidade;
private Integer idEstado;


public void setFuncionario(Funcionario funcionario) {
	this.funcionario = funcionario;
}
public Funcionario getFuncionario() {
	return funcionario;
}


// Metodos de Ação 

@PostConstruct
public void novo(){
 funcionario = new Funcionario();
 EstadoSalvar est = new EstadoSalvar();
 estados = est.listaEstados();
 cidades = new  ArrayList<Cidade>();
}

public void cidadeDados(){
Est_CidadeDao cida = new Est_CidadeDao();
	cidades = cida.lista(idEstado);

}

public void salvar(){
	try{
	EntityManager manger = Factory.getFactory();
CidadeDao cid = new CidadeDao();
	Cidade cidade = manger.find(Cidade.class, idCidade);
	funcionario.setCidade(cidade);
	FuncionarioDao cida = new FuncionarioDao();
	cida.salvar(funcionario);
	Messages.addGlobalInfo("Funcionario Cadastrado com Sucesso!!");
	novo();
	}catch(RuntimeException e){
	Messages.addGlobalError("Erro ao Salva Funcionnario");
		e.getStackTrace();	
	}
	
}
	
	


}
