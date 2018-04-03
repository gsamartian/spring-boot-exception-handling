package com.example.springbootexceptionhandling;


public class ServiceException extends Exception {
	
	String code;
	
	public String getCode(){
		return code;
	}
	
	public ServiceException(String code,String message) {
		super(message);
		this.code=code;
		
	}
	
}	