package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
	
@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

		@Autowired
		EntrepriseRepository entrepriseRepository;

		private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	 	
		@Override
		public List<Entreprise> retrieveAllEntreprise() { 
			List<Entreprise> entreprises = null; 
			try {
				
				l.info("In Method retrieveAllEntreprise :");
				entreprises = (List<Entreprise>) entrepriseRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (Entreprise entreprise : entreprises) {
					l.debug("entreprise :" + entreprise.getName()); 
				} 
				l.info("Out of Method retrieveAllEntreprises with Success" + entreprises.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllEntreprises with Errors : " + e); 
			}

			return entreprises;
		}


		@Override
		public Entreprise addEntreprise(Entreprise c) {
			
			Entreprise c_saved = null; 
			
			try {
				// TODO Log à ajouter en début de la méthode 
				l.info("In Method addEntreprise :");
				c_saved = entrepriseRepository.save(c); 
				// TODO Log à ajouter à la fin de la méthode 
				l.info("Out of Method addEntreprise with Success" );
				
			} catch (Exception e) {
				// TODO log ici : l....("error in addUser() : " + e);
				l.error("Out of Method addEntreprise with Errors : " + e);
			}
			
			return c_saved; 
		}

		@Override 
		public Entreprise updateEntreprise(Entreprise c) {
			
			Entreprise entrepriseUpdated = null; 
			
			try {
				// TODO Log à ajouter en début de la méthode 
				l.info("In Method updateEntreprise :");
				entrepriseUpdated = entrepriseRepository.save(c); 
				// TODO Log à ajouter à la fin de la méthode 
				l.info("Out of Method updateEntreprise with Success" );
				
			} catch (Exception e) {
				// TODO log ici : l....("error in updateUser() : " + e);
				l.error("Out of Method updateEntreprise with Errors : " + e);
			}
			
			return entrepriseUpdated; 
		}

		@Override
		public void deleteEntreprise(String id) {
			
			try {
				// TODO Log à ajouter en début de la méthode 
				l.info("In Method deleteEntreprise :");
				entrepriseRepository.deleteById(Long.parseLong(id)); 
				// TODO Log à ajouter à la fin de la méthode 
				l.info("Out of Method deleteEntreprise with Success" );			
			} catch (Exception e) {
				// TODO log ici : l....("error in deleteUser() : " + e);
				l.error("Out of Method deleteEntreprise with Errors : " + e);
			}
			
		}

		@Override
		public Entreprise retrieveEntreprise(String id) {
			Entreprise c = null; 
			try {
				// TODO Log à ajouter en début de la méthode 
				l.info("In Method retrieveEntreprise :");
				c =  entrepriseRepository.findById(Long.parseLong(id)).get(); 
				// TODO Log à ajouter à la fin de la méthode
				l.info("Out of Method retrieveEntreprise with Success" );
				
			} catch (Exception e) {
				// TODO log ici : l....("error in retrieveUser() : " + e);
				l.error("Out of Method retrieveEntreprise with Errors : " + e);
			}

			return c; 
		}




	}


