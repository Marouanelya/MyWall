package com.polytech.config;

import com.polytech.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by dev on 3/16/17.
 */
@SpringBootApplication
@Import(ApplicationConfig.class)
public class ApplicationStarter {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","DEV");
        System.out.println("STAAAAAAAAAAAAAAAAAAAAART !");
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
