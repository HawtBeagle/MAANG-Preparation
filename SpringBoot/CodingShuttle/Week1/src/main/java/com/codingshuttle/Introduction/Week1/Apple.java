package com.codingshuttle.Introduction.Week1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Apple {

    private int value;

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    void eat(){
        System.out.println("I am eating apple");
    }

    @PostConstruct
    void callMeAfterIntilizing(){
        System.out.println("After creating the apple bean");
    }

    @PreDestroy
    void callMeBeforeDestroying(){
       System.out.println("Before destroying the apple bean");
    }
}
