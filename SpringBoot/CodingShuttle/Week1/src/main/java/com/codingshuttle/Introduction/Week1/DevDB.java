package com.codingshuttle.Introduction.Week1;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "db.profile", havingValue = "development")
public class DevDB implements DB{

    @Override
    public String getData() {
        return "Dev Data";
    }
}
