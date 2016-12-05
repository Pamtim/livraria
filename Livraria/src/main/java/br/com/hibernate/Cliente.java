package br.com.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
@Id
@GeneratedValue
private Integer Id;
private String nome;
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
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getBarrio() {
	return barrio;
}
public void setBarrio(String barrio) {
	this.barrio = barrio;
}
public Cidade getCidade() {
	return cidade;
}
public void setCidade(Cidade cidade) {
	this.cidade = cidade;
}


public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getRg() {
	return rg;
}
public void setRg(String rg) {
	this.rg = rg;
}
public short getNumero() {
	return numero;
}
public void setNumero(short numero) {
	this.numero = numero;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFoto() {
	return foto;
}
public void setFoto(String foto) {
	this.foto = foto;
}
public Date getNascimento() {
	return nascimento;
}
public void setNascimento(Date nascimento) {
	this.nascimento = nascimento;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getSexo() {
	return sexo;
}
@Column(nullable=false)
private String sexo ;
@Column(nullable=false)
private String endereco ;
@Column(nullable=false)
private String barrio ;
@OneToOne
private Cidade cidade;
private String  cep ;
@Column(unique=true,nullable=false)
private String cpf;
private String rg;
private short numero ;
private String telefone;
@Column(nullable=false)
private String email;
private String foto;
@Column(nullable=false)
private Date nascimento;
}
