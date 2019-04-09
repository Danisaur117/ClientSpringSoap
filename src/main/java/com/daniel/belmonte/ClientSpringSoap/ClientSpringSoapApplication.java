package com.daniel.belmonte.ClientSpringSoap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.daniel.belmonte.schemas.actors.GetAllActorsRequest;
import com.daniel.belmonte.schemas.actors.GetAllActorsResponse;

@SpringBootApplication
public class ClientSpringSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientSpringSoapApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup (SoapConnector soapConnector) {
		return args -> {
			
			
			GetAllActorsRequest request = new GetAllActorsRequest();
			GetAllActorsResponse response = (GetAllActorsResponse)soapConnector.callWebService("http://localhost:8080/ws/actors.wsdl", request);
			
			System.out.println(response.getActorType().get(0).getActorId() + ": " +
							   response.getActorType().get(0).getFirstName() + " " + 
							   response.getActorType().get(0).getLastName() + " - " +
							   response.getActorType().get(0).getLastUpdate());
		};
	}
}
