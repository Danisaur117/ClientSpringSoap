package com.daniel.belmonte.ClientSpringSoap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
		marshaller.setContextPath("com.daniel.belmonte.schemas.actors");
		
		return marshaller;
	}
	
	@Bean
	public SoapConnector soapConnector(Jaxb2Marshaller marshaller) {
		SoapConnector soapConnector = new SoapConnector();
		
		soapConnector.setDefaultUri("http://localhost:8080/ws/actors.wsdl");
		soapConnector.setMarshaller(marshaller);
		soapConnector.setUnmarshaller(marshaller);
		
		return soapConnector;
	}
}
