package com.bsuir.localchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.bsuir.localchain.properties")
public class LocalchainApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalchainApplication.class, args);
    }

}
