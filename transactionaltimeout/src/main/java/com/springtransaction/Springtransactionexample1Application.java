package com.springtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//we can provide a transaction timeout using @Transactinal annotation

/*
 When we define @Transactional(timeout = 100) then 
 we are saying our transaction should complete in given time frame otherwise we will get 
 TransactionException(transaction time expired error).

The time value type should be int and it would be considered in milliseconds.

By default value of timeout is -1. That means no timeouts has been supported.
 * */

@SpringBootApplication(scanBasePackages={"com.springtransaction"})
@EntityScan("com.springtransaction.*") 
public class Springtransactionexample1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springtransactionexample1Application.class, args);
	}

}
