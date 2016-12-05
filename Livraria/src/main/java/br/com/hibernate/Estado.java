package br.com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.omnifaces.converter.SelectItemsConverter;

@Entity
public class Estado{
@Id
@GeneratedValue
private Integer id ;
private String nome ;
@Column(length=2)
private String sigla;

public void setNome(String nome) {
	this.nome = nome;
}
public void setSigla(String sigla) {
	this.sigla = sigla;
}
public Integer getId() {
	return id;
}
public void setId(Integer id){
	this.id = id;
}
public String getNome() {
	return nome;
}
public String getSigla() {
	return sigla;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Estado other = (Estado) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
