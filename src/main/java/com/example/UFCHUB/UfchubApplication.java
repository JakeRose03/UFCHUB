package com.example.UFCHUB;

import com.example.UFCHUB.Service.FighterDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UfchubApplication implements CommandLineRunner {
	@Autowired
	FighterDataLoader fighterDataLoader;
	public static void main(String[] args) {
		SpringApplication.run(UfchubApplication.class, args);
		System.out.println("working");
	}
	@Override
	public void run(String... args) throws Exception {
		fighterDataLoader.loadFighters();
	}




}
