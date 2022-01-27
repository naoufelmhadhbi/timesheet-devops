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

import tn.esprit.spring.entities.Contrat;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiceImplTest{

	@Autowired
	IContratService cs;
	
	@Test
	@Order (1)
	public void Contrats() {
		
		List<Contrat> listUsers = cs.retrieveAllContrats();
		//ma base de données contient trois users
		// je vais vérifier si ma base me retourne vraiment trois users avec la methode assertEquals 
		Assertions.assertEquals(0, listUsers.size());
	}
	
	@Test
	@Order (2)
	public void testaddContrat() throws ParseException, java.text.ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-12");
		Contrat c = new Contrat(d, "CDI", 1500); // le user ça sera ajouter avec l'id 4 puisque j'ai trois ancien users
		Contrat ContratAdded = cs.addContrat(c);
		Assertions.assertEquals(c.getReference(), ContratAdded.getReference());
		
	}
	
	@Test
	@Order (3)
	public void testupdateContrat() throws ParseException, java.text.ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d_mofied = dateFormat.parse("2018-03-12");
		Contrat c = new Contrat(3L, d_mofied, "CDI", 1500); // L pour dire de type long | D double | F float
		Contrat ContratUpdated = cs.updateContrat(c);
		Assertions.assertEquals(c.getReference(), ContratUpdated.getReference());
		
	}
	
	@Test
	@Order (4)
	public void testretrieveContrat() {
		
		Contrat contratRetrieved = cs.retrieveContrat("1"); 
		Assertions.assertEquals(1L, contratRetrieved.getReference());
		
	}
	
	@Test
	@Order (5)
	public void testdeleteContrat() {
		
		cs.deleteContrat("1"); 
		Assertions.assertNull(cs.retrieveContrat("1"));
		
	}
}
