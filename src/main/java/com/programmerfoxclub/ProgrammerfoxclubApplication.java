package com.programmerfoxclub;

import com.programmerfoxclub.repositories.Tricks;
import com.programmerfoxclub.services.TricksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgrammerfoxclubApplication implements CommandLineRunner {
    private TricksService tricksService;

    @Autowired
    public ProgrammerfoxclubApplication (TricksService tricksService) {
        this.tricksService = tricksService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProgrammerfoxclubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
