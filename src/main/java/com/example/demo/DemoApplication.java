package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
@EnableJpaAuditing
public class DemoApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(DemoApplication.class, args);
    }

}
