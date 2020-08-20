package com.springreactive.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreactive.bms.dao.LoanRepository;
import com.springreactive.bms.domain.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService{
	
@Autowired
LoanRepository loanRepository;

@Override
public Mono<Loan> findByUsername(String username) {
	// TODO Auto-generated method stub
	return loanRepository.findByUsername(username) ;
}

@Override
public Flux<Loan> findAll() {
	// TODO Auto-generated method stub
	return loanRepository.findAll();
}

@Override
public Mono<Loan> save(Loan loan) {
	// TODO Auto-generated method stub
	return loanRepository.save(loan);
}


}

