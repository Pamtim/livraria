package br.com.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Livro {
@Id 
@GeneratedValue
private Integer Id;
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Date getPublicação() {
	return publicação;
}
public void setPublicação(java.util.Date dat) {
	this.publicação = dat;
}
public Autor getAutor() {
	return autor;
}
public void setAutor(Autor autor) {
	this.autor = autor;
}
public Editora getEditora() {
	return editora;
}
public void setEditora(Editora editora) {
	this.editora = editora;
}
private String nome ;
private Date publicação;
@OneToOne 
private Autor autor;
@OneToOne 
private Editora editora ;

private String genero;

@Column(nullable=false)
private float valor ;
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public void setGenero(String genereo) {
	this.genero = genereo;
}
public String getGenero() {
	return genero;
}

}
