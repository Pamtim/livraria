package br.com.hibernate;

import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
@Id
@GeneratedValue
private Integer id;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
private String senha;
public void setSenha(String senha) {
	this.senha = senha;
}
public String getSenha() {
	return senha;
}

@OneToOne
private Funcionario funcionario;
public Funcionario getFuncionario() {
	return funcionario;
}
public void setFuncionario(Funcionario funcionario) {
	this.funcionario = funcionario;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public boolean isStatu() {
	return statu;
}
public void setStatu(boolean statu) {
	this.statu = statu;
}


private String tipo ;
private boolean statu;

@Transient
public String format(){
	if(statu){
		return "Ativado";
	}
	return "Desativado";
}
@Transient
public String tipoform(){
	if(tipo.equals("A")){
		return "Administrador";
	}
	if(tipo.equals("V")){
		return "Vendedor";
	}
	if(tipo.equals("G")){
		return "Gerente";
	}
	return "Convidado";
}

}
