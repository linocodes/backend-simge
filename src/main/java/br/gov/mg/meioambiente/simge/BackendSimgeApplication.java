package br.gov.mg.meioambiente.simge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.gov.mg.meioambiente")
public class BackendSimgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendSimgeApplication.class, args);
	}
}
