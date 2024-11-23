package com.codingshuttle.Introduction.Week1;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "db.profile", havingValue = "production")
public class ProdDB implements DB{

    @Override
    public String getData() {
        return "Prod Data";
    }
}
