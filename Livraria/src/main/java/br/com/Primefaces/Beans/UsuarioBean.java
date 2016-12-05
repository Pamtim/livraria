package br.com.Primefaces.Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import org.omnifaces.util.Messages;
import br.com.hibernate.Funcionario;
import br.com.hibernate.Usuario;
import br.com.hibernate.util.Factory;
import br.com.hibernate.util.FuncionarioDao;
import br.com.hibernate.util.UsuarioDao;

@ManagedBean
@ViewScoped
public class UsuarioBean {
private Usuario usuario;
private List<Usuario> usuarios;
private List<Funcionario>funcionarios;
private Integer idFuncionario;
private Integer idUser;

public Integer getIdUser() {
	return idUser;
	}
public void setIdUser(Integer idUser) {
	this.idUser = idUser;
}
public void setFuncionarios(List<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}
public void setIdFuncionario(Integer idFuncionario) {
	this.idFuncionario = idFuncionario;
}
public List<Funcionario> getFuncionarios() {
	return funcionarios;
}
public Integer getIdFuncionario() {
	return idFuncionario;
}
public List<Usuario> getUsuarios() {
	return usuarios;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
}




@PostConstruct
public void Novo(){
	UsuarioDao user =  new UsuarioDao();
	FuncionarioDao fun  = new FuncionarioDao(); 
	usuario = new Usuario();
    funcionarios = 	fun.lista();
    usuarios = user.lista();
    
}
	


// Metodos de Ação 

public void salvar(){
	try{
EntityManager manger = Factory.getFactory();
Funcionario funcionario = manger.find(Funcionario.class,idFuncionario);
usuario.setFuncionario(funcionario);
UsuarioDao user = new UsuarioDao();
user.salvar(usuario);
Novo();
usuarios=user.lista();
Messages.addGlobalInfo("Funcioanrio Salvo Com sucesso!");
	}catch(RuntimeException e){
		e.getStackTrace();
		Messages.addGlobalError("Erro ao Salvar Funcionario");
	}
	
	
}


public void editar (ActionEvent event){
usuario = (Usuario) event.getComponent().getAttributes().get("editar");	
idFuncionario = usuario.getFuncionario().getId();
}

public void excluir(Integer id){
try{	
UsuarioDao user = new UsuarioDao();
Usuario user2 = user.buscaUser(id);
user.excluir(usuario.getId());
Messages.addGlobalError("Erro ao Excluido com Sucessoo");
usuario = new Usuario();
}catch(RuntimeException e ){
	Messages.addGlobalError("Erro ao Excluir ususario");
	System.out.println(e.getStackTrace());
}
}
	
	
}
