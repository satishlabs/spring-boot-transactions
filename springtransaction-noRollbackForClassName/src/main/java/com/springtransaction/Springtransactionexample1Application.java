package com.springtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages={"com.springtransaction"})
@EntityScan("com.springtransaction.*") 
public class Springtransactionexample1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springtransactionexample1Application.class, args);
	}

}
