package com.mycompany.webapp.exception;

public class notFoundAccountException extends RuntimeException{

	public notFoundAccountException() {}
	
	public notFoundAccountException(String message) {
		super(message);
	}
}
