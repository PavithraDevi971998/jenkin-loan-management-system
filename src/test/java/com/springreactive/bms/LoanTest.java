package com.springreactive.bms;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.springreactive.bms.dao.LoanRepository;
import com.springreactive.bms.domain.Loan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
@RunWith(SpringRunner.class)
public class LoanTest {
	@Autowired
	LoanRepository loanRepository;

    List<Loan>  itemList = Arrays.asList(new Loan("pavi","savings",40000,"12/09/2009",10,6),
            new Loan("kalai","business",50000,"22/03/2019",60,4),
            new Loan("rudhra","education",30000,"09/07/1999",10,6),
            new Loan("raj","finance",70000,"31/04/2002",10,6));
           
    @Before
    public void setUp(){

    	loanRepository.deleteAll()
                .thenMany(Flux.fromIterable(itemList))
                .flatMap(loanRepository::save)
                .doOnNext((item -> {
                    System.out.println("Inserted Item is :" + item);
                }))
                .blockLast();

    }

@Test
public void getAllItems() {

       StepVerifier.create(loanRepository.findAll()) // 2
                .expectSubscription()
                .expectNextCount(4)
                .verifyComplete();
    }	
@Test
public void getustomerUsername() {

	        StepVerifier.create(loanRepository.findByUsername("pavi"))
	                .expectSubscription()
	                .expectNextMatches((customer -> customer.getLoantype().equals("savings")))
	                .verifyComplete();


	    }
@Test
public void saveItem(){

	Loan loan = new Loan("sam","house",80000,"19/01/2019",20,16);
    Mono<Loan> savedItem = loanRepository.save(loan);
    StepVerifier.create(savedItem.log("saveItem : "))
            .expectSubscription()
            .expectNextMatches(item1 -> (item1.getUsername().equals("sam") && item1.getDurationofloan()==16))
            .verifyComplete();

}
	
	

}
