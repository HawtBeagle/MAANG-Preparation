package com.codingshuttle.Introduction.Week1.Doubts;

import org.springframework.util.Assert;

public class Assertion {
    public static void isAssertion() {
        int i=0;
        try {
            Assert.isTrue(i == 10, "i not equal to 10");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
