package com.example.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.bot"}) // scan your whole package
public class GoogleBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoogleBotApplication.class, args);
    }
}
