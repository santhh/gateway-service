package com.google.swarm.microservice.model;


import java.util.List;


import lombok.Data;

@Data
public class Student {

	private String studentId;
	private String firstName;
	private String lastName;
	private List<Registration> registrations;

}
