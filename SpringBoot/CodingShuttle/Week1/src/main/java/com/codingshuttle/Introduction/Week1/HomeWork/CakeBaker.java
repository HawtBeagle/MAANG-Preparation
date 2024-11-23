package com.codingshuttle.Introduction.Week1.HomeWork;

import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private Frosting frosting;
    private Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public String bakeCake() {
        return frosting.getFrostingType() + syrup.getSyrupType();
    }
}
