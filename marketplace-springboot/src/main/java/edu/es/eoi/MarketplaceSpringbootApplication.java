package edu.es.eoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MarketplaceSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceSpringbootApplication.class, args);
	}

}
