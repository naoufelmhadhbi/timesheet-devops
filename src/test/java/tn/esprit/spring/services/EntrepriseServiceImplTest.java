package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;

import tn.esprit.spring.entities.Entreprise;

public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService cs;
	
	@Test
	@Order (1)
	public void Entreprises() {
		
		List<Entreprise> listEntreprises = cs.retrieveAllEntreprise();
		//ma base de données contient trois users
		// je vais vérifier si ma base me retourne vraiment trois users avec la methode assertEquals 
		Assertions.assertEquals(0, listEntreprises.size());
	}
	
	@Test
	@Order (2)
	public void testaddEntreprise() throws ParseException, java.text.ParseException {
		
		Entreprise c = new Entreprise("entreprise1", "entreprise1"); // le user ça sera ajouter avec l'id 4 puisque j'ai trois ancien users
		Entreprise EntrepriseAdded = cs.addEntreprise(c);
		Assertions.assertEquals(c.getName(), EntrepriseAdded.getName());
		
	}
	
	@Test
	@Order (3)
	public void testupdateEntreprise() throws ParseException, java.text.ParseException {
		
		Entreprise c = new Entreprise("entreprise2", "entreprise1"); // L pour dire de type long | D double | F float
		Entreprise EntrepriseUpdated = cs.updateEntreprise(c);
		Assertions.assertEquals(c.getName(), EntrepriseUpdated.getName());
		
	}
	
	@Test
	@Order (4)
	public void testretrieveEntreprise() {
		
		Entreprise entrepriseRetrieved = cs.retrieveEntreprise("1"); 
		Assertions.assertEquals(1L, entrepriseRetrieved.getName());
		
	}
	
	@Test
	@Order (5)
	public void testdeleteEntreprise() {
		
		cs.deleteEntreprise("1"); 
		Assertions.assertNull(cs.retrieveEntreprise("1"));
		
	}

}
