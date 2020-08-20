package com.springreactive.bms.service;

import com.springreactive.bms.domain.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService {
	Mono<Loan> findByUsername(String username);

	Flux<Loan> findAll();

	Mono<Loan> save(Loan loan);

	

}
