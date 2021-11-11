package br.unip.victor.iservicesbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="br.unip.victor.iservicesbackend")
public class IServicesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IServicesBackendApplication.class, args);
	}

}
