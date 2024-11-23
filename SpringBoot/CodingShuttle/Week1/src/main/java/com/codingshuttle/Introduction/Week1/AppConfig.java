package com.codingshuttle.Introduction.Week1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    @Scope("singleton")
    Apple createApple(){
        return new Apple();
    }
}
