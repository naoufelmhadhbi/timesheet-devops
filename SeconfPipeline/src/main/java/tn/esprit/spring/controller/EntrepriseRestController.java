package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

public class EntrepriseRestController {


	// Couplage Faible 
	@Autowired 
	IEntrepriseService entrepriseService; 
 
	// URL : http://localhost:????/????/retrieve-all-entreprises
	@GetMapping("/retrieve-all-entreprise")
	public List<Entreprise> retrieveAllEntreprise() {
		List<Entreprise> list = entrepriseService.retrieveAllEntreprise();
		return list;
	}
 
	// http://localhost:????/timesheet-devops/retrieve-entreprise/{entreprise-id}
	@GetMapping("/retrieve-entreprise/{entreprise-id}")
	public Entreprise retrieveContrat(@PathVariable("entreprise-id") String entrepriseId) {
		return entrepriseService.retrieveEntreprise(entrepriseId);
	}

	// Ajouter Entreprise : http://localhost:????/timesheet-devops/add-entreprise 
	@PostMapping("/add-entreprise")
	public Entreprise addEntreprise(@RequestBody Entreprise u) {
		Entreprise entreprise = entrepriseService.addEntreprise(u); 
		return entreprise;
	}

	
	// Supprimer Entreprise : 
	// http://localhost:????/timesheet-devops/remove-entreprise/{entreprise-id}
	@DeleteMapping("/remove-entreprise/{entreprise-id}") 
	public void removeEntreprise(@PathVariable("entreprise-id") String entrepriseId) { 
		entrepriseService.deleteEntreprise(entrepriseId);
	} 

	// Modifier Entreprise 
	// http://localhost:????/timesheet-devops/modify-entreprise 
	@PutMapping("/modify-entreprise") 
	public Entreprise updateEntreprise(@RequestBody Entreprise entreprise) {
		return entrepriseService.updateEntreprise(entreprise);
	}
}
