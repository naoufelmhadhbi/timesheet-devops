package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {
	
	@Autowired
	IEmployeService es;
	
	@Test
	@Order (1)
	public void testretrieveAllEmployees() {		
		List<Employe> listEmployees = es.retrieveEmployees();
		//ma base de données contient quatre users
		// je vais vérifier si ma base me retourne vraiment trois users avec la methode assertEquals 
		Assertions.assertEquals(0, listEmployees.size());
	}
	
	@Test
	@Order (2)
	public void testaddEmploye() throws ParseException, java.text.ParseException {
			
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//Date d = dateFormat.parse("2015-03-12");
		Employe e = new Employe("Ahmed", "Ben Ahmed", "ahmed.benahmed@test.com", true, Role.INGENIEUR); // le user ça sera ajouté avec l'id 4 puisque j'ai trois ancien users
		Employe EmployeAdded = es.addEmploye(e);
		Assertions.assertEquals(e.getNom(), EmployeAdded.getNom());
			
	}
	
	@Test
	@Order (3)
	public void testupdateEmploye() throws ParseException, java.text.ParseException {
			
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Employe e = new Employe(1L, "Ahmed_modified", "Ben Ahmed", "ahmed.benahmed@test.com", true, Role.INGENIEUR); // L pour dire de type long | D double | F float
		Employe employeUpdated = es.updateEmploye(e);
		Assertions.assertEquals(e.getNom(), employeUpdated.getNom());
			
		}
	
	@Test
	@Order (4)
	public void testretrieveEmploye() {
		
		Employe EmployeRetrieved = es.getEmploye(Long.parseLong("1")); 
		Assertions.assertEquals(1L, EmployeRetrieved.getId());
		
	}
	
	@Test
	@Order (5)
	public void testdeleteEmploye() {
		
		es.deleteEmploye(Long.parseLong("1")); 
		Assertions.assertNull(es.getEmploye(Long.parseLong("1")));
		
	}
}
