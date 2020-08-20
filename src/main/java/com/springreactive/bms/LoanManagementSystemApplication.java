package com.springreactive.bms;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@SpringBootApplication
public class LoanManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemApplication.class, args);
		
		
	}

}
