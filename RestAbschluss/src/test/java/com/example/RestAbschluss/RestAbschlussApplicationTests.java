package com.example.RestAbschluss;

import com.example.RestAbschluss.produkte.Produkt;
import com.example.RestAbschluss.produkte.ProduktReposetory;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RestAbschlussApplicationTests {


	private static final String produktName="Schue";

	@Autowired
	private ProduktReposetory produktReposetory;

	@BeforeEach
	public void addProdukt(){
		Produkt produkt=new Produkt();
		produkt.setName(produktName);
		produkt.setKosten(55);

		produktReposetory.save(produkt);

	}

	@AfterEach
	public void clean(){
		produktReposetory.deleteAll();
	}


	@Test
	void testGetRequest() {

		TestRestTemplate testRestTemplate=new TestRestTemplate();




		ResponseEntity<Produkt>responseEntity=testRestTemplate.getForEntity("http://localhost:8080/produkte/1", Produkt.class);

		Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		Assertions.assertNotNull(responseEntity.getBody());
Assertions.assertEquals(responseEntity.getBody().getName(),produktName);
	}

}
