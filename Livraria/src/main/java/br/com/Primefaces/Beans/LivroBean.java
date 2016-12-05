package br.com.Primefaces.Beans;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.omnifaces.util.Messages;

import br.com.hibernate.Autor;
import br.com.hibernate.Editora;
import br.com.hibernate.Genero;
import br.com.hibernate.Livro;
import br.com.hibernate.util.AutorDao;
import br.com.hibernate.util.EditoraDao;
import br.com.hibernate.util.Factory;
import br.com.hibernate.util.GeneroDao;
import br.com.hibernate.util.LivroDao;

@ManagedBean
@ViewScoped
public class LivroBean {
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
private Livro livro ;
private String data;
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public Livro getLivro() {
	return livro;
}
public void setLivro(Livro livro) {
	this.livro = livro;
}
public List<Livro> getLivros() {
	return livros;
}
public void setLivros(List<Livro> livros) {
	this.livros = livros;
}
public List<Autor> getAutores() {
	return autores;
}
public void setAutores(List<Autor> autores) {
	this.autores = autores;
}
public List<Editora> getEditoras() {
	return editoras;
}
public void setEditoras(List<Editora> editoras) {
	this.editoras = editoras;
}
public Integer getIdEditora() {
	return idEditora;
}
public void setIdEditora(Integer idEditora) {
	this.idEditora = idEditora;
}
public Integer getIdAutor() {
	return idAutor;
}
public void setIdAutor(Integer idAutor) {
	this.idAutor = idAutor;
}
private List<Livro> livros ;
private List<Autor> autores;
private List<Editora> editoras ;
private Integer idEditora ;
private Integer idAutor;
	
	
// Metodos de ação 


public void novo(){
	try{ 
AutorDao au= new AutorDao();
autores = au.lista();
EditoraDao edi = new EditoraDao();
editoras = edi.lista();
livro = new Livro();	
	}catch(RuntimeException e){
	Messages.addGlobalError("Erro ao criar um novo livro");	
	}
}

public void salvar(){
try{
EntityManager manger = Factory.getFactory();
Editora ed = manger.find(Editora.class, idEditora);	
Autor autor = manger.find(Autor.class,idAutor);

livro.setAutor(autor);
livro.setEditora(ed);
LivroDao li = new LivroDao();
EditoraDao editora = new EditoraDao();
AutorDao aut = new AutorDao();
li.salvar(livro);
livros=li.lista();
novo();
Messages.addGlobalInfo("Livro Salvo com sucesso!!");
}catch(RuntimeException e){
e.getStackTrace();
Messages.addGlobalError("Erro ao salvar Livro!!");

	
}
}
@PostConstruct
public void lista(){
LivroDao li = new LivroDao();
livros = li.lista();	
}

public void excluir(ActionEvent e ){
try{
livro = (Livro) e.getComponent().getAttributes().get("excluir");	
LivroDao li = new LivroDao();
li.Excluir(livro.getId());
}catch(RuntimeException ex){
	Messages.addGlobalError("Erro ao Ecluir o livro");
	ex.getStackTrace();
}
}

public void editar(ActionEvent e){
	livro = (Livro)e.getComponent().getAttributes().get("editar");
	idEditora = livro.getEditora().getId();
	idAutor = livro.getAutor().getId();

}


// Metodo de Auto incremento 
private List<String> listas ;
 
public  List<Genero> metodo(String query){
GeneroDao ge = new GeneroDao();
 return ge.busca(query);
}
 




}
