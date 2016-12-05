package br.com.hibernate.util;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.Primefaces.Beans.AutenticacaoBean;
import br.com.hibernate.Usuario;

@SuppressWarnings("serial")
public class ConfigAutenticacao implements PhaseListener {
	static AutenticacaoBean  autentica;
	@Override
	public void afterPhase(PhaseEvent event) {
		
  FacesContext faces = event.getFacesContext();
   UIViewRoot view =   faces.getViewRoot();
   String atual = view.getViewId();
   if(atual.contains("index.xhtml")){
	   
   }else{
   ExternalContext context = faces.getExternalContext();
   Map<String,Object> map = context.getSessionMap();
    autentica = (AutenticacaoBean) map.get("autenticacaoBean");	
   Usuario user=null;

	if( autentica == null){
		try {
			Faces.redirect("./pages/index.xhtml");
		} catch (IOException e) {
  Messages.addGlobalError("Erro ao : "+e.getMessage());
			e.printStackTrace();
		}
	}else{
		 user = autentica.getUsuariologado();
	}
   
	if(user == null){
	try {
		Faces.redirect("./pages/index.xhtml");
	} catch (IOException e) {
   
		e.printStackTrace();
	}
		
	}
	
   }
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}
	

}
