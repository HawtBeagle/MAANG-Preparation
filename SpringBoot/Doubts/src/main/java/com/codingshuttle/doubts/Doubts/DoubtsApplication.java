package com.codingshuttle.doubts.Doubts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoubtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoubtsApplication.class, args);
		StreamExplore.print();
		//stream cannot be used more than once
		//StreamExplore.print();
	}

}
