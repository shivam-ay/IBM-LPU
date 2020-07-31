package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.AccountResponseEntity;

@ControllerAdvice
public class LoanDetailsExceptionHandler 
{
	@ExceptionHandler 
	public ResponseEntity<AccountResponseEntity> handleException(AccountNotFoundException unfe) 
	{ 
		return new ResponseEntity<AccountResponseEntity>(new AccountResponseEntity(HttpStatus.NOT_FOUND.value(),unfe.getMsg(),System.currentTimeMillis()),HttpStatus.NOT_FOUND); 
	} 

}
