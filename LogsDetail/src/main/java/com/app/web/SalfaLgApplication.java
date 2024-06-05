package com.app.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.out;
@SpringBootApplication
public class SalfaLgApplication {
	public static void main(String[] args) {
		SpringApplication.run(SalfaLgApplication.class, args);
		out.print("executed main Application");
	}

}
