package br.com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estoque {
@Id
@GeneratedValue
private Integer id ;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Livro getLivro() {
	return livro;
}
public void setLivro(Livro livro) {
	this.livro = livro;
}
public Integer getQuantidade() {
	return quantidade;
}
public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}
@OneToOne
private Livro livro ;
@Column(nullable=false)
private Integer quantidade;
		
}
