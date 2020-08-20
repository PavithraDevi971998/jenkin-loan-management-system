package com.springreactive.bms.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springreactive.bms.domain.ExceptionResponse;
import com.springreactive.bms.domain.Loan;

import com.springreactive.bms.service.LoanService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class LoanController extends ResponseEntityExceptionHandler{
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/loan")
	public Mono<Loan> loandetails(@Valid @RequestBody Loan loan){
		
		return loanService.save(loan);
	}
	
	@GetMapping(path="/loan/username/{username}")
	public Mono<Loan> logincheck(@PathVariable String username ){
		return loanService.findByUsername(username);}

	@GetMapping("/loan/findall")
	public Flux<Loan> loanvalues()
	{
		
		return loanService.findAll();
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}	
}
