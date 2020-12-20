package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.codegym.entity")
@SpringBootApplication
public class FuramaResortApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuramaResortApplication.class, args);
    }

}
