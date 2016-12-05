package br.com.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {
   @Id
   @GeneratedValue
   private Integer id ;
   public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
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
public Short getNumero() {
	return numero;
}
public void setNumero(Short numero) {
	this.numero = numero;
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
public Date getAdmissão() {
	return admissão;
}
public void setAdmissão(Date admissão) {
	this.admissão = admissão;
}
public Date getNascimento() {
	return nascimento;
}
public void setNascimento(Date nascimento) {
	this.nascimento = nascimento;
}
public Cidade getCidade() {
	return cidade;
}
public void setCidade(Cidade cidade) {
	this.cidade = cidade;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public Long getNumeroCat() {
	return numeroCat;
}
public void setNumeroCat(Long numeroCat) {
	this.numeroCat = numeroCat;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getComplemento() {
	return complemento;
}
public void setComplemento(String complemento) {
	this.complemento = complemento;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
private String nome ;
   private String endereco;
   private String barrio;
   private Short numero;
   @Column(unique=true,length=16)
   private String cpf;
   @Column(unique=true,length=20)
   private String rg;
   private Date admissão;
   private Date nascimento;
  @OneToOne
   private Cidade cidade;
   private String telefone;
   private Long numeroCat;
   private String email;
   private String complemento;
   private String sexo;
}
