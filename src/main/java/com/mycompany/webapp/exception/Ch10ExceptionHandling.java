package com.mycompany.webapp.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class Ch10ExceptionHandling {

	/*@ExceptionHandler
	public String nullPointer(NullPointerException e) {
		return "ch10/nullpointerexception";
	}*/
	
	@ExceptionHandler
	public String runtime(RuntimeException e) {
		return "ch10/runtimeException";
	}
	
	@ExceptionHandler
	public String runtime(notFoundAccountException e) {
		return "ch10/notFoundAccountException";
	}
	
}
