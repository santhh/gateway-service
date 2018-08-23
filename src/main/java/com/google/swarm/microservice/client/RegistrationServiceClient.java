package com.google.swarm.microservice.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.swarm.microservice.model.Registration;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegistrationServiceClient {
	static private final Logger logger = LoggerFactory.getLogger(StudentServiceClient.class);

	private final RestTemplate restTemplate;
	 public List<Registration> getRegistrations(String studentId)
	    {
		
//		 ResponseEntity<List<Registration>> response = restTemplate.exchange("http://localhost:8082/api/registration/{studentId}",
//                 HttpMethod.GET, HttpEntity.EMPTY,
//                 new ParameterizedTypeReference<List<Registration>>() {},
//                 studentId);	
		 
		 
		   ResponseEntity<List<Registration>> response = restTemplate.exchange("http://registration-service:8082/api/registration/{studentId}",
	                 HttpMethod.GET, HttpEntity.EMPTY,
	                 new ParameterizedTypeReference<List<Registration>>() {},
	                 studentId);

		 	List<Registration> registrations = response.getBody();
	    	return registrations;
	    	
	    }
}
