package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest{

	@Autowired
	IUserService us;
	
	@Test
	@Order (1)
	public void testretrieveAllUsers() {
		
		List<User> listUsers = us.retrieveAllUsers();
		//ma base de données contient trois users
		// je vais vérifier si ma base me retourne vraiment trois users avec la methode assertEquals 
		Assertions.assertEquals(2, listUsers.size());
	}
	
	@Test
	@Order (2)
	public void testaddUser() throws ParseException, java.text.ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-12");
		User u = new User("Ahmed", "Ahmed", d, Role.INGENIEUR); // le user ça sera ajouter avec l'id 4 puisque j'ai trois ancien users
		User UserAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), UserAdded.getLastName());
		
	}
	
	@Test
	@Order (3)
	public void testupdateUser() throws ParseException, java.text.ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-12");
		User u = new User(10L,"Ahmed_modified", "Ahmed", d, Role.INGENIEUR); // L pour dire de type long | D double | F float
		User UserUpdated = us.updateUser(u);
		Assertions.assertEquals(u.getLastName(), UserUpdated.getLastName());
		
	}
	
	@Test
	@Order (4)
	public void testretrieveUser() {
		
		User userRetrieved = us.retrieveUser("10"); 
		Assertions.assertEquals(10L, userRetrieved.getId());
		
	}
	
	@Test
	@Order (5)
	public void testdeleteUser() {
		
		us.deleteUser("10"); 
		Assertions.assertNull(us.retrieveUser("10"));
		
	}
}
