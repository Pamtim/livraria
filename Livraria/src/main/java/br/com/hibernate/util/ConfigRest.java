package br.com.hibernate.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
@ApplicationPath("rest")
public class ConfigRest extends ResourceConfig {
public ConfigRest(){
	packages("br.com.hibernate.servico");
}
	
}
