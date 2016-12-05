package br.com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.omnifaces.converter.SelectItemsConverter;

@Entity
public class Cidade   {
@Id
@GeneratedValue
private Integer Id;
private String nome ;
@OneToOne
private Estado  estado;
public Estado getEstado() {
	return estado;
}
public void setEstado(Estado estado) {
	this.estado = estado;
}
public Integer getId() {
	return Id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public void setId(Integer id) {
	Id = id;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
	Cidade other = (Cidade) obj;
	if (Id == null) {
		if (other.Id != null)
			return false;
	} else if (!Id.equals(other.Id))
		return false;
	return true;
}


}
