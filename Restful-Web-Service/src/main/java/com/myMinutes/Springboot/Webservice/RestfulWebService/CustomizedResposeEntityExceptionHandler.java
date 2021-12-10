package com.myMinutes.Springboot.Webservice.RestfulWebService;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myMinutes.Springboot.Webservice.RestfulWebService.Exception.ExceptionResponse;

@RestController
@ControllerAdvice
public class CustomizedResposeEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionRespose = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ExceptionResponse>(exceptionRespose, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionRespose = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ExceptionResponse>(exceptionRespose, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionRespose = new ExceptionResponse(new Date(), "validation failed", ex.getBindingResult().toString());
		
		return new ResponseEntity(exceptionRespose, HttpStatus.BAD_REQUEST);
		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
}
