package com.rab3.demo.firstpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rab3"})
public class Rab32Application {

	public static void main(String[] args) {
		SpringApplication.run(Rab32Application.class, args);
	}

}