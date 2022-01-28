package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;

import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService cs;
	
	@Test
	@Order (1)
	public void Entreprises() {
		
		List<Entreprise> listEntreprises = cs.retrieveAllEntreprise();
		//ma base de données est vide
		Assertions.assertEquals(0, listEntreprises.size());
	}
	
	@Test
	@Order (2)
	public void testaddEntreprise() throws ParseException, java.text.ParseException {
		
		Entreprise c = new Entreprise("entreprise1", "entreprise1");
		Entreprise EntrepriseAdded = cs.addEntreprise(c);
		Assertions.assertEquals(c.getName(), EntrepriseAdded.getName());
		
	}
	
	@Test
	@Order (3)
	public void testupdateEntreprise() throws ParseException, java.text.ParseException {
		
		Entreprise c = new Entreprise(1L, "entreprise2", "entreprise2");
		Entreprise EntrepriseUpdated = cs.updateEntreprise(c);
		Assertions.assertEquals(c.getName(), EntrepriseUpdated.getName());
		
	}
	
	@Test
	@Order (4)
	public void testretrieveEntreprise() {
		
		Entreprise entrepriseRetrieved = cs.retrieveEntreprise("1"); 
		Assertions.assertEquals("entreprise2", entrepriseRetrieved.getName());
		
	}
	
	@Test
	@Order (5)
	public void testdeleteEntreprise() {
		
		cs.deleteEntreprise("1"); 
		Assertions.assertNull(cs.retrieveEntreprise("1"));
		
	}

}
