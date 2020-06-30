package tn.esprit.ClientFacture.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.ClientFacture.entities.Facture;
import tn.esprit.ClientFacture.exception.ResourceNotFoundException;
import tn.esprit.ClientFacture.repositories.FactureRepository;

@Service
public class FactureService {
	@Autowired
	private FactureRepository factureRepository;
	
	public ResponseEntity<Facture> getById(Long factureId) throws ResourceNotFoundException {
		Facture facture = factureRepository.findById(factureId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + factureId));
		return ResponseEntity.ok().body(facture);
	}
	
	
	public List <Facture> getFactureByid(long id) {return factureRepository.findFactureByIdClient(id);}
	
	
}
