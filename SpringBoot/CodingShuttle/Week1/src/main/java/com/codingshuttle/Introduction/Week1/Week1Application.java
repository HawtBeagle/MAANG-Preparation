package com.codingshuttle.Introduction.Week1;

import com.codingshuttle.Introduction.Week1.Doubts.Assertion;
import com.codingshuttle.Introduction.Week1.Doubts.EmployeeTest;
import com.codingshuttle.Introduction.Week1.Doubts.Singleton;
import com.codingshuttle.Introduction.Week1.HomeWork.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

@SpringBootApplication
public class Week1Application implements CommandLineRunner {

	@Autowired
	Apple apple1;

	@Autowired
	@Qualifier("createApple")
	Apple apple2;

	@Autowired
	private DBService dbService;

	@Autowired
	private CakeBaker cakeBaker;

	@Autowired
	private EmployeeTest empTest;


	public static void main(String[] args) {
    	System.out.println("Before spring boot");

		SpringApplication.run(Week1Application.class, args);
    //	System.out.println("After commandline runner");

//		Singleton s1 = Singleton.createInstance();
//		Singleton s2 = Singleton.createInstance();
//    	System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
	}

	@Override
	public void run(String... args) throws Exception {
    	System.out.println("This is the starting of the application");
    //		apple1.setValue(5);
    //	    System.out.println(apple1.getValue());
    //		System.out.println(apple2.getValue());
    //		//apple1.eat();
    //		//apple2.eat();
    //
    //		int i=10;
    //
    //		Assertion.isAssertion();
    //
    //    	System.out.println(apple1.hashCode());
    //		System.out.println(apple2.hashCode());

    		System.out.println(dbService.getData());
    		System.out.println(cakeBaker.bakeCake());


			empTest.runForClass();
			empTest.runForRecord();

	}
}
