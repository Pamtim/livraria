package br.com.Primefaces.Beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.hibernate.Funcionario;
import br.com.hibernate.Usuario;
import br.com.hibernate.util.UsuarioDao;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
private Usuario usuario;
private Usuario usuariologado;

public Usuario getUsuariologado() {
	return usuariologado;
}
public void setUsuariologado(Usuario usuariologado) {
	this.usuariologado = usuariologado;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

@PostConstruct
public void novo (){
	usuario = new Usuario();
	usuario.setFuncionario( new Funcionario());
    
}


public boolean  acesso(List<String> dado){
	
	
	boolean res = false;
	if(dado!=null){
		for (String d : dado) {
			
		
		if(d.equals(usuariologado.getTipo())){
		
			res = true;
			break;
			
		}else{
			System.out.println("Diferente");
			res = false;
		}
		}
		
		return res;
	}else{
		return false ;
	}
}

public void autenticar(){
	try{
		UsuarioDao  user = new UsuarioDao();
	usuariologado = user.busca(usuario.getFuncionario().getCpf(),usuario.getSenha());
		if(usuariologado == null){
		 Messages.addGlobalError(" CPF e/ou senha Incorreto !!");
		 return;
		}
		if(usuariologado.isStatu()){
	
		Faces.redirect("./pages/principal.xhtml");
		}else{
			Messages.addGlobalError("Conta de usuario Desativada!!");
		}
	}catch(RuntimeException e){
		Messages.addGlobalError(" Senha e/ou CPF incorreto !!");
	}catch(IOException e){
		Messages.addGlobalError("Erro ao Redireciona Pagina");

	}
	
}

public void destruir(){
	try{
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("autenticacaoBean");
	Faces.redirect("pages/index.xhtml");
	}catch(IOException e){
		Messages.addGlobalError("Erro ao Fazer Logof");
	}
}

}
