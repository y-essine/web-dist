package com.example.microassurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroAssuranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroAssuranceApplication.class, args);
    }

}
