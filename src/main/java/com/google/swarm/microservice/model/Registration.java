package com.google.swarm.microservice.model;


import lombok.Data;

@Data
public class Registration {
private String registrationId;
private String studentId;
private String courseId;
private String cost= String.valueOf("$0");

}
