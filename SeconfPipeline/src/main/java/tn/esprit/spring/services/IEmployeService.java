package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {

	List<Employe> retrieveEmployees(); 
	Employe addEmploye(Employe e);
	void deleteEmploye(Long id);
	Employe updateEmploye(Employe e);
	Employe getEmploye(Long id);
}
