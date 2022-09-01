package com.esspl.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
//@RestController
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception{
		
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Object> handleAllException2(Exception ex, WebRequest request) throws Exception{
		
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),"ProductNotFoundException",request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.CONFLICT);
	}
		
	
	
}
