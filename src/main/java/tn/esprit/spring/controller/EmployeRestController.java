package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RestController
public class EmployeRestController {

	@Autowired 
	IEmployeService es; 
 
	@GetMapping("/retrieve-all-employees")
	public List<Employe> retrieveEmployees() {
		List<Employe> list = es.retrieveEmployees();
		return list;
	}
 
	@GetMapping("/retrieve-employee/{employe-id}")
	public Employe retrieveUser(@PathVariable("employe-id") Long employeId) {
		return es.getEmploye(employeId);
	}

	@PostMapping("/add-employe")
	public Employe addUser(@RequestBody Employe e) {
		Employe employe = es.addEmploye(e); 
		return employe;
	}

	
	@DeleteMapping("/remove-employe/{employe-id}") 
	public void removeUser(@PathVariable("employe-id") Long employeId) { 
		es.deleteEmploye(employeId);
	} 

	@PutMapping("/modify-employe") 
	public Employe updateUser(@RequestBody Employe e) {
		return es.updateEmploye(e);
	}
}
