package br.com.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import br.com.hibernate.*;
@SuppressWarnings("serial")
@Entity
public class VendaBean implements Serializable {
@Id
@GeneratedValue
private Integer id ;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getData_venda() {
	return data_venda;
}
public void setData_venda(Date data_venda) {
	this.data_venda = data_venda;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Funcionario getFuncioanrio() {
	return funcioanrio;
}
public void setFuncioanrio(Funcionario funcioanrio) {
	this.funcioanrio = funcioanrio;
}
public List<Livro_Item> getLivros() {
	return itens;
}
public void setLivros(List<Livro_Item> livros) {
	this.itens = livros;
}
private Date data_venda;
@Column(nullable=false)
private float total ;
@OneToOne
private Cliente cliente ;
@OneToOne
private Funcionario funcioanrio ;
@OneToMany()
private List<Livro_Item> itens;

	
}
