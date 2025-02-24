package com.lalit.awslog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PyramidMain {

	public static void main(String[] args) {
		SpringApplication.run(PyramidMain.class, args);
	}

}
