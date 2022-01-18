package com.example.parserwithweb;

import com.example.parserwithweb.configuration.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParserWithWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {ParserWithWebApplication.class, JpaConfig.class}, args);
    }

}
