package br.com.Primefaces.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.omnifaces.util.Messages;

import br.com.hibernate.Estoque;
import br.com.hibernate.Livro;
import br.com.hibernate.util.EstoqueDao;
import br.com.hibernate.util.Factory;
import br.com.hibernate.util.LivroDao;

@ManagedBean
@ViewScoped
public class EstoqueBean {
	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	private List<Estoque> estoques ;
	private Estoque estoque ;
	private int idLivro;
	private Livro livro ;
	private List<Livro> livros;
	private String statu ="";
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}


// Metodos de Ação 
	
	@PostConstruct
	public void novo(){
	estoque = new Estoque();
	EstoqueDao li = new EstoqueDao();
	estoques = li.lista();
	LivroDao livro = new LivroDao();
	livros = livro.lista();
	}
	
	public void instaci(){
		livro = new Livro();
		LivroDao liv = new LivroDao();
		livros= liv.lista();
		estoque = new Estoque();
		idLivro = 0;
	} 
	
	public void adicionar(){
		try{
		statu = "";
	boolean contem=true ;
	EntityManager manger = Factory.getFactory();
	livro=manger.find(Livro.class,idLivro);
	EstoqueDao est = new EstoqueDao();
	if(estoques != null){
	for (Estoque estoque : estoques) {
		
		if(livro.getNome().equals(estoque.getLivro().getNome())){
		contem=true;
		break;
		}else{
			contem=false;
		}
		
	}
	}else{
		statu = "Adicionando Estoque";
		estoque.setLivro(livro);
		est.salvar(estoque);
		statu = "Atualizando Estoque";
		estoques=est.lista();
		statu = "Atualizando Livros";
		LivroDao livr =  new LivroDao();
		livros=livr.lista();
		instaci();
	    idLivro = 0;
		Messages.addGlobalInfo("Livro adicionado no Estoque");	
	}
	if(contem){
		Messages.addGlobalError("O Livro "+livro.getNome()+" Ja foi Adicionado no Estoque");
	}else{
	statu = "Adicionando Estoque";
	estoque.setLivro(livro);
	est.salvar(estoque);
	statu = "Atualizando Estoque";
	estoques=est.lista();
	statu = "Atualizando Livros";
	LivroDao livr =  new LivroDao();
	livros=livr.lista();
	instaci();
    idLivro = 0;
	Messages.addGlobalInfo("Livro adicionado no Estoque");
	}
		}catch(RuntimeException e){
		Messages.addGlobalError("Erro ao adicionar Livro : "+e.getMessage());	
		System.out.println(""+e.getMessage());
		}
	}
	
	public void addEditar(){
		try{
			statu = "";
		boolean contem=true ;
		EntityManager manger = Factory.getFactory();
		livro=manger.find(Livro.class,idLivro);
		EstoqueDao est = new EstoqueDao();
		statu = "Adicionando Estoque";
		estoque.setLivro(livro);
		est.salvar(estoque);
		statu = "Atualizando Estoque";
		estoques=est.lista();
		statu = "Atualizando Livros";
		LivroDao livr =  new LivroDao();
		livros=livr.lista();
		instaci();
	    idLivro = 0;
		Messages.addGlobalInfo("Livro Atualizado no Estoque");
		}catch(RuntimeException e){
			Messages.addGlobalInfo("Erro : "+e.getMessage());
		}
	}
	
	public void remover(ActionEvent e){
		statu ="";
	estoque =(Estoque)e.getComponent().getAttributes().get("remover");	
	EstoqueDao est = new EstoqueDao();
	statu="exluindo livro";
	est.excluir(estoque.getId());
	statu="Atualizando Estoque";
	estoques = est.lista();
	Messages.addGlobalInfo("Livro removido com Sucesso!");
	}
	
	
	
	public void editar(ActionEvent e){
		estoque = (Estoque) e.getComponent().getAttributes().get("edita");
		idLivro = estoque.getLivro().getId();
	}
	
}
