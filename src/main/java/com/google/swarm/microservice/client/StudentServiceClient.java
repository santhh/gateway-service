package com.google.swarm.microservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.swarm.microservice.controller.GatewayServiceController;
import com.google.swarm.microservice.model.Student;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class StudentServiceClient {
	static private final Logger logger = LoggerFactory.getLogger(StudentServiceClient.class);
 
	private final RestTemplate restTemplate;
	 public Student getStudent(final String studentId) {
			
		 	
	        //Student student= restTemplate.getForObject("http://localhost:8081/api/students/{studentId}", Student.class, studentId);
	        Student student= restTemplate.getForObject("http://student-service:8081/api/students/{studentId}", Student.class, studentId);
	        return student;
	    	
	    }
}
