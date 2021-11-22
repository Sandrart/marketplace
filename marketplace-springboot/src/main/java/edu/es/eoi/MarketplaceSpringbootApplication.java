package edu.es.eoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@ComponentScan(basePackages = "edu.es.eoi")
public class MarketplaceSpringbootApplication {

     public static void main(String[] args) {
     SpringApplication.run(MarketplaceSpringbootApplication.class, args);
	}

	
	
	
}
