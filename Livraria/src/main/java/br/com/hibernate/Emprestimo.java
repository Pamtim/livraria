package br.com.hibernate;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Emprestimo {
@Id
@GeneratedValue
private Integer id;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public List<Livro> getLivros() {
	return livros;
}
public void setLivros(List<Livro> livros) {
	this.livros = livros;
}
public Date getDataEmprestimo() {
	return dataEmprestimo;
}
public void setDataEmprestimo(Date dataEmprestimo) {
	this.dataEmprestimo = dataEmprestimo;
}
public Date getDataEntrega() {
	return dataEntrega;
}
public void setDataEntrega(Date dataEntrega) {
	this.dataEntrega = dataEntrega;
}
public float getJuros() {
	return juros;
}
public void setJuros(float juros) {
	this.juros = juros;
}
@OneToOne 
private Cliente cliente;
@OneToMany
private List<Livro> livros; 
private Date dataEmprestimo;
private Date dataEntrega;
private float juros;	

	
	
}
