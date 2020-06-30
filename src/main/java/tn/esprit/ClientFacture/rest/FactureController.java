package tn.esprit.ClientFacture.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.ClientFacture.entities.Facture;
import tn.esprit.ClientFacture.exception.ResourceNotFoundException;
import tn.esprit.ClientFacture.services.FactureService;

@CrossOrigin(origins="*")
@RestController
public class FactureController {
	@Autowired
	private FactureService factureService;
	
	@GetMapping("/factures/{id}")
	public List<Facture> getClientById(@PathVariable(value = "id") Long factureId)
			 {
		return factureService.getFactureByid(factureId);
	}
	
}
