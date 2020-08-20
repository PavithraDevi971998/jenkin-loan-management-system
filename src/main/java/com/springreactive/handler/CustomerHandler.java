package com.springreactive.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.springreactive.bms.dao.LoanRepository;
import com.springreactive.bms.domain.Loan;

import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {

    @Autowired
    LoanRepository loanRepository;

    public Mono<ServerResponse> getAllItems(ServerRequest serverRequest){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(loanRepository.findAll(), Loan.class);

    }
}
