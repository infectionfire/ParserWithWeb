package com.example.parserwithweb;

import com.example.parserwithweb.configuration.JpaConfig;
import com.example.parserwithweb.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
@ConfigurationPropertiesScan
@SpringBootApplication
public class ParserWithWebApplication {

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {ParserWithWebApplication.class, JpaConfig.class}, args);
    }

}
