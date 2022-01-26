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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

// contratRestControl
@RestController // = @Controller + @ResponseBody 
//@Scope("session") 
// singleton c'est par défaut 
// prototype 
// request 
public class ContratRestControl {

	// Couplage Faible 
	@Autowired 
	IContratService contratService; 
 
	// URL : http://localhost:????/????/retrieve-all-contrats
	@GetMapping("/retrieve-all-contrats")
	public List<Contrat> retrieveAllCotnrats() {
		List<Contrat> list = contratService.retrieveAllContrats();
		return list;
	}
 
	// http://localhost:????/timesheet-devops/retrieve-contrat/{contrat-id}
	@GetMapping("/retrieve-contrat/{contrat-id}")
	public Contrat retrieveContrat(@PathVariable("contrat-id") String contratId) {
		return contratService.retrieveContrat(contratId);
	}

	// Ajouter Contrat : http://localhost:????/timesheet-devops/add-contrat 
	@PostMapping("/add-contrat")
	public Contrat addContrat(@RequestBody Contrat u) {
		Contrat contrat = contratService.addContrat(u); 
		return contrat;
	}

	
	// Supprimer Contrat : 
	// http://localhost:????/timesheet-devops/remove-contrat/{contrat-id}
	@DeleteMapping("/remove-contrat/{contrat-id}") 
	public void removeContrat(@PathVariable("contrat-id") String contratId) { 
		contratService.deleteContrat(contratId);
	} 

	// Modifier Contrat 
	// http://localhost:????/timesheet-devops/modify-contrat 
	@PutMapping("/modify-contrat") 
	public Contrat updateContrat(@RequestBody Contrat contrat) {
		return contratService.updateContrat(contrat);
	}
	 
} 
 