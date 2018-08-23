package com.google.swarm.microservice.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.swarm.microservice.client.RegistrationServiceClient;
import com.google.swarm.microservice.client.StudentServiceClient;
import com.google.swarm.microservice.model.Registration;
import com.google.swarm.microservice.model.Student;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/jpa/v1")
public class GatewayServiceController {
	static private final Logger logger = LoggerFactory.getLogger(GatewayServiceController.class);
 
	private final StudentServiceClient studentServiceClient;
	private final RegistrationServiceClient registrationServiceClient;
    
    
	@GetMapping(value = "/students/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
 
    	logger.info("Getting Student Registration Record by Student Id: {}", studentId);
    	Student student = studentServiceClient.getStudent(studentId);
    	
    	if (student!=null) {
    		List <Registration> registrations = registrationServiceClient.getRegistrations(student.getStudentId());
    		if (registrations!=null) {
    			student.setRegistrations(registrations);
    		}
    		
    	}
    
    	return student;
    }
	@GetMapping(value = "/students")
    public Student getStudents() {
	
		Random r = new Random();
		IntStream randomStudent = r.ints(1, 100000);
		Integer id = randomStudent.findFirst().getAsInt();
		return getStudent(String.valueOf(id));
		
	
	
	}
}
