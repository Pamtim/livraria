package br.com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Editora {
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column(nullable=true)
private String nome;
private String email;
}
