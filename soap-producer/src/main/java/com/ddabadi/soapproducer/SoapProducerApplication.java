package com.ddabadi.soapproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({ "com.ddabadi.*" })
public class SoapProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapProducerApplication.class, args);
	}
}
