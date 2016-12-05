package br.com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Livro_Item {
@Id 
@GeneratedValue
private Integer id ;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getQuantidade() {
	return quantidade;
}
public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}
public VendaBean getVenda() {
	return venda;
}
public void setVenda(VendaBean venda) {
	this.venda = venda;
}
public Livro getLivro() {
	return livro;
}
public void setLivro(Livro livro) {
	this.livro = livro;
}
public float getValortotal() {
	return valortotal;
}
public void setValortotal(float valortotal) {
	this.valortotal = valortotal;
}
@Column(nullable=false)
private Integer quantidade;
@OneToOne
private VendaBean venda ;
@OneToOne
private Livro livro;
private float valortotal;
}
