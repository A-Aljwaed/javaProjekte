package com.example.DataConnector.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DataConnectorPostgresApplication {

	@RestController
	public class CityContoller{
		@Autowired
		StadtReposetory stadtReposetory;


@GetMapping("/Paris")
		public Citys Paris(){
	return stadtReposetory.findByName("Paris");
}
	}

	public static void main(String[] args) {
//		SpringApplication.run(DataConnectorPostgresApplication.class, args);

		ConfigurableApplicationContext apx=SpringApplication.run(DataConnectorPostgresApplication.class,args);

		Citys paris = new Citys();
		paris.setName("Paris");
		paris.setCapital(true);

		Citys rastatt = new Citys();
		rastatt.setName("Rastatt");
		rastatt.setCapital(false);


		Citys karlsruhe = new Citys();
		karlsruhe.setName("Karlsruhe");
		karlsruhe.setCapital(false);



		StadtReposetory stp = apx.getBean(StadtReposetory.class);
		stp.save(rastatt);
		stp.save(karlsruhe);
		stp.save(paris);


	}
}
