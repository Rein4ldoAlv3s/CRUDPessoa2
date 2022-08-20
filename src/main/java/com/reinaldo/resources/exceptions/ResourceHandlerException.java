package com.reinaldo.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.reinaldo.services.exceptions.DataIntegrityViolationException;
import com.reinaldo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException o){
		StandardError error = new StandardError(o.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException d){
		StandardError error = new StandardError(d.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
