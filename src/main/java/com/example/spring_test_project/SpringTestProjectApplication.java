package com.example.spring_test_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestProjectApplication.class, args);
    }

}
