package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;


@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contratRepository;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
 	
	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
			
			l.info("In Method retrieveAllContrats :");
			contrats = (List<Contrat>) contratRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Contrat contrat : contrats) {
				l.debug("contrat :" + contrat.getTypeContrat()); 
			} 
			l.info("Out of Method retrieveAllContrats with Success" + contrats.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllContrats with Errors : " + e); 
		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat c) {
		
		Contrat c_saved = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method addContrat :");
			c_saved = contratRepository.save(c); 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("Out of Method addContrat with Success" );
			
		} catch (Exception e) {
			// TODO log ici : l....("error in addUser() : " + e);
			l.error("Out of Method addContrat with Errors : " + e);
		}
		
		return c_saved; 
	}

	@Override 
	public Contrat updateContrat(Contrat c) {
		
		Contrat contratUpdated = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method updateContrat :");
			contratUpdated = contratRepository.save(c); 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("Out of Method updateContrat with Success" );
			
		} catch (Exception e) {
			// TODO log ici : l....("error in updateUser() : " + e);
			l.error("Out of Method updateContrat with Errors : " + e);
		}
		
		return contratUpdated; 
	}

	@Override
	public void deleteContrat(String id) {
		
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method deleteContrat :");
			contratRepository.deleteById(Long.parseLong(id)); 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("Out of Method deleteContrat with Success" );			
		} catch (Exception e) {
			// TODO log ici : l....("error in deleteUser() : " + e);
			l.error("Out of Method deleteContrat with Errors : " + e);
		}
		
	}

	@Override
	public Contrat retrieveContrat(String id) {
		Contrat c = null; 
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method retrieveContrat :");
			c =  contratRepository.findById(Long.parseLong(id)).get(); 
			// TODO Log à ajouter à la fin de la méthode
			l.info("Out of Method retrieveContrat with Success" );
			
		} catch (Exception e) {
			// TODO log ici : l....("error in retrieveUser() : " + e);
			l.error("Out of Method retrieveContrat with Errors : " + e);
		}

		return c; 
	}

}
