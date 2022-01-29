package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {
	
	@Autowired
	EmployeRepository er;
	
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<Employe> retrieveEmployees() {
		List<Employe> employees = null; 
		try {
			
			l.info("In Method retrieveEmployees :");
			employees = (List<Employe>) er.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Employe employe : employees) {
				l.debug("user :" + employe.getNom()); 
			} 
			l.info("Out of Method retrieveEmployees with Success" + employees.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveEmployees with Errors : " + e); 
		}

		return employees;
	}

	@Override
	public Employe addEmploye(Employe employe) {
		Employe e_saved = null; 
		
		try {
			l.info("In Method addEmploye :");
			e_saved = er.save(employe); 
			l.info("Out of Method addEmploye with Success" );
			
		} catch (Exception e) {
			l.error("Out of Method addEmploye with Errors :  " + e);
		}
		
		return e_saved; 
	}

	@Override
	public void deleteEmploye(Long id) {
		try {
			l.info("In Method deleteEmploye :");
			er.deleteById(id); 
			l.info("Out of Method deleteEmploye with Success" );			
		} catch (Exception e) {
			l.error("Out of Method deleteEmploye with Errors : " + e);
		}
		
	}

	@Override
	public Employe updateEmploye(Employe employe) {
		Employe eUpdated = null; 
		
		try {
			l.info("In Method updateEmploye :");
			eUpdated = er.save(employe); 
			l.info("Out of Method updateEmploye with Success" );
			
		} catch (Exception e) {
			l.error("Out of Method updateEmploye with Errors : " + e);
		}
		
		return eUpdated; 
	}

	@Override
	public Employe getEmploye(Long id) {
		Employe employe = null; 
		try {
			l.info("In Method getEmploye :");
			employe =  er.findById(id).get(); 
			l.info("Out of Method getEmploye with Success" );
			
		} catch (Exception e) {
			l.error("Out of Method getEmploye with Errors : " + e);
		}

		return employe;
	}

}
