package com.example.DataConnector.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataConnectorPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataConnectorPostgresApplication.class, args);

		ConfigurableApplicationContext apx=SpringApplication.run(DataConnectorPostgresApplication.class);
		Citys rastatt = new Citys();
		rastatt.setName("Rastatt");
		rastatt.setCapital(false);


		Citys karlsruhe = new Citys();
		karlsruhe.setName("Karlsruhe");
		karlsruhe.setCapital(false);

		Citys paris = new Citys();
		paris.setName("Paris");
		paris.setCapital(true);

		StadtReposetory stp = apx.getBean(StadtReposetory.class);
		stp.save(rastatt);
		stp.save(karlsruhe);
		stp.save(paris);


	}
}
