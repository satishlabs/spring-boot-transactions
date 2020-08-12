package com.springtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/*
 @Transactional(propagation=Propagation.REQUIRED) – 
 If there is not an existing transaction it will create a new transaction. 
 In case if there is already an existing transaction it will not create a new transaction
 
 
 @Transactional(propagation=Propagation.REQUIRES_NEW) – 
 Even if there is already an existing transaction it will create a new transaction i.e it will always create a new transaction.
 
 To understand Propagation.REQUIRED  and Propagation.REQUIRES_NEW just assume following scenario.
  Suppose we want to save two entity Book.java and Stroy.java(both are independent entity means they 
  don’t have either inheritance relationship or association relationship). 
  We have two separate methods to save the book and story entity. 
  The method which saving story is getting called from saveBook() method. 
  Is it confusing? Let’s see in below code snippet.

We have two separate implementations classes BookServiceImpl.java and StoryServiceImpl.java with saveBook() and saveStory() method respectively. 
saveStory() is getting called from saveBook().
 
 * */


@SpringBootApplication(scanBasePackages={"com.springtransaction"})
@EntityScan("com.springtransaction.*") 
public class Springtransactionexample1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springtransactionexample1Application.class, args);
	}

}
