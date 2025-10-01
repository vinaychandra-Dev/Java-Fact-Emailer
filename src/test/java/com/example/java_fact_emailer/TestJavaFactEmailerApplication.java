package com.example.java_fact_emailer;

import org.springframework.boot.SpringApplication;

public class TestJavaFactEmailerApplication {

	public static void main(String[] args) {
		SpringApplication.from(JavaFactEmailerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
