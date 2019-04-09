package com.daniel.belmonte.ClientSpringSoap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.context.annotation.Bean;

public class SoapConnector extends WebServiceGatewaySupport {
	
	@Bean
	public Object callWebService(String url, Object request) {
		return getWebServiceTemplate().marshalSendAndReceive(url, request);
	}
}
