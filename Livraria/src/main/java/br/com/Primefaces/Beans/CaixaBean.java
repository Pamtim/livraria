package br.com.Primefaces.Beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.omnifaces.util.Messages;

import br.com.hibernate.Cliente;
import br.com.hibernate.Estoque;
import br.com.hibernate.Funcionario;
import br.com.hibernate.Livro;
import br.com.hibernate.Livro_Item;
import br.com.hibernate.VendaBean;
import br.com.hibernate.util.ClienteDao;
import br.com.hibernate.util.EstoqueDao;
import br.com.hibernate.util.FuncionarioDao;
import br.com.hibernate.util.VendaDao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CaixaBean implements Serializable {
	@ManagedProperty(value="#{autenticacaoBean}")
	private AutenticacaoBean aut ;
private  List<Estoque> livros;
private List<Estoque>livrosFilter;
private Funcionario func ;
private Integer idfunc; 
private List<Funcionario> funcionarios;
public AutenticacaoBean getAut() {
	return aut;
}
public void setAut(AutenticacaoBean aut) {
	this.aut = aut;
}
public List<Funcionario> getFuncionarios() {
	return funcionarios;
}
public void setFuncionarios(List<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}
public Integer getIdfunc() {
	return idfunc;
}
public void setIdfunc(Integer idfunc) {
	this.idfunc = idfunc;
}
public void setFunc(Funcionario func) {
	this.func = func;
}
public Funcionario getFunc() {
	return func;
}
public List<Estoque> getLivrosFilter() {
	return livrosFilter;
}
public void setLivrosFilter(List<Estoque> livrosFilter) {
	this.livrosFilter = livrosFilter;
}
public List<Estoque> getLivros() {
	return livros;
}


public void setLivros(List<Estoque> livros) {
	this.livros = livros;
}

public List<Livro_Item> getLivrosItens() {
	return livrosItens;
}

public void setLivrosItens(List<Livro_Item> livrosItens) {
	this.livrosItens = livrosItens;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Float getValorTotal() {
	return valorTotal;
}

public void setValorTotal(Float valorTotal) {
	this.valorTotal = valorTotal;
}

private List<Livro_Item> livrosItens ;
private Cliente cliente ;
private List<Cliente> clientes;
private Float valorTotal = Float.parseFloat("0");
private Estoque livro ;
private Integer idCliente;
public Estoque getLivro() {
	return livro;
}
public void setLivro(Estoque livro) {
	this.livro = livro;
}
public Integer getIdCliente() {
	return idCliente;
}
public void setIdCliente(Integer idCliente) {
	this.idCliente = idCliente;
}
public List<Cliente> getClientes() {
	return clientes;
}
public void setClientes(List<Cliente> clientes) {
	this.clientes = clientes;
}

@PostConstruct
public void novo(){
EstoqueDao lv = new EstoqueDao();
	
    livros =  lv.lista();
    livrosItens =  new ArrayList<Livro_Item>();
    livro = new Estoque();
    clientes = new ArrayList<Cliente>();
    cliente = new Cliente();
}

public void addLista(ActionEvent e){
	livro = (Estoque) e.getComponent().getAttributes().get("adicionar");
	try{
     if(livrosItens.isEmpty()){
    Livro_Item item = new Livro_Item();	 
    item.setQuantidade(1);
    item.setValortotal(livro.getLivro().getValor());
    item.setLivro(livro.getLivro());
    livrosItens.add(item);
    valorTotal = item.getValortotal();
   baixaEstoque(livro.getLivro(),1);
    calculoValorT();
     }else{
    int indice = -1;
    int cont = 0 ;
   for (Livro_Item item : livrosItens) {
	   
	   if(item.getLivro().getNome().equals(livro.getLivro().getNome())){
		   indice = cont; 
		 break;
	   }
	   cont++;
}
    
    if(indice>=0){
    Livro_Item item2 = livrosItens.get(indice);
    int qu = item2.getQuantidade() + 1;
   item2.setQuantidade(qu);
   item2.setValortotal(livro.getLivro().getValor()*qu);
   baixaEstoque(livro.getLivro(),1);
   calculoValorT();
    }else{
    	Livro_Item item = new Livro_Item();	 
        item.setQuantidade(1);
        item.setValortotal(livro.getLivro().getValor());
        item.setLivro(livro.getLivro());
        
        livrosItens.add(item);
        valorTotal = item.getValortotal();
        calculoValorT();	
        baixaEstoque(livro.getLivro(),1);
    }
    	 
    	 
     }
		
		
	}catch(RuntimeException ex){
		Messages.addGlobalError("Erro: "+ex.getMessage());
	}
	}
	
public void baixaEstoque(Livro livro,Integer quant){
	EstoqueDao est = new EstoqueDao();
    Estoque liv = est.busca(livro);
    int qu=liv.getQuantidade();
   liv.setQuantidade(qu - quant);
   est.salvar(liv);
}public CaixaBean() {
	// TODO Auto-generated constructor stub
}

public void addEstoque(Livro livro,Integer quant){
	EstoqueDao est = new EstoqueDao();
    Estoque liv = est.busca(livro);
    int qu=liv.getQuantidade();
   liv.setQuantidade(qu + quant);
   est.salvar(liv);
}

public void remover(ActionEvent e){
Livro_Item  item = (Livro_Item)e.getComponent().getAttributes().get("remover");
int quant =item.getQuantidade();
if(quant>1){
for (Livro_Item itemt : livrosItens) {
	if(item.getId()==itemt.getId()){
	    itemt.setQuantidade(quant-1);
	  int valor =  itemt.getQuantidade();
	  itemt.setValortotal(item.getLivro().getValor()*valor);
	    addEstoque(item.getLivro(),1);
	    calculoValorT();
	}
}

}else{
int ind = livrosItens.indexOf(item);
Livro_Item item2 = livrosItens.remove(ind);
addEstoque(item.getLivro(),1);
calculoValorT();
}	

}

public void calculoValorT(){
int cont = 0 ;
	for (Livro_Item item : livrosItens) {
	if(cont==0){
		valorTotal = item.getValortotal();
	}else{
	valorTotal += item.getValortotal();
	}
	cont++;
	}	
	
}

public void venda (){
ClienteDao cli = new ClienteDao();
clientes = cli.listaCli();
FuncionarioDao fun = new FuncionarioDao();
funcionarios  = fun.lista();
}

public void finalizar (){
try{
VendaBean venda = new VendaBean();
VendaDao vendadao = new VendaDao();	
venda.setLivros(livrosItens);
venda.setData_venda(new Date());
venda.setTotal(valorTotal);
venda.setFuncioanrio(aut.getUsuariologado().getFuncionario());
ClienteDao cli = new ClienteDao();
cliente = cli.buscaCli(idCliente);
venda.setCliente(cliente);
vendadao.salvar(venda);
Messages.addGlobalInfo("Venda Realizada com Sucesso");
livrosItens =  new ArrayList<Livro_Item>();
}catch(RuntimeException e ){
	Messages.addGlobalError("Erro ao Finalizar compra :"+e.getMessage());
	e.getStackTrace();
	System.out.println("Erro:"+e.getMessage());


}
}
	
}
