package com.example.sport_supplements;

import com.example.sport_supplements.view.MyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportSupplementsApplication implements CommandLineRunner {
	@Autowired
	private MyView view;

	public static void main(String[] args) {
		SpringApplication.run(SportSupplementsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		view.show();
	}
}
