package com.packt.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication extends SpringBootServletInitializer{
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository urepository;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CardatabaseApplication.class);
	}

	public static void main(String[] args) {
		// After adding this line the project is restarted
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			repository.save(car);
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			repository.save(car);
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			repository.save(car);

			urepository.save(new User("user", "$2y$12$x8lYDQ1u/CAZ1RBqyEZT.O/ew2375B1gd1TZm49wwfvLoL25y0kRe", "USER"));
			urepository.save(new User("admin", "$2a$10$mKs/y2vTlE1EddAr82B8T.n8sL/ZFdI9AY.OBcwCbv.dOWieT/lsK", "ADMIN"));
		};
	}
}
