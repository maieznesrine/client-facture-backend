package tn.esprit.ClientFacture.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.ClientFacture.entities.Client;
import tn.esprit.ClientFacture.exception.ResourceNotFoundException;
import tn.esprit.ClientFacture.services.ClientService;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getClients();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		return clientService.getById(clientId);
	}

	@PostMapping("/clients")
	public Client createEmployee(@Validated @RequestBody Client client) {
		return clientService.createClient(client);
	}

	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientId,
			@Validated @RequestBody Client clientDetails) throws ResourceNotFoundException {
		return clientService.updateClient(clientId, clientDetails);

	}
	
	@DeleteMapping("/client/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		return clientService.deleteClient(clientId);

	}

}
