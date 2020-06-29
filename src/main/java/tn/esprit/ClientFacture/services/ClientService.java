package tn.esprit.ClientFacture.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.ClientFacture.entities.Client;
import tn.esprit.ClientFacture.exception.ResourceNotFoundException;
import tn.esprit.ClientFacture.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	
	public List<Client> getClients() {
		return clientRepository.findAll();
	}
	
	public ResponseEntity<Client> getById(Long clientId) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		return ResponseEntity.ok().body(client);
	}
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}
	
	public ResponseEntity<Client> updateClient(Long clientId,Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id : " + clientId));

		client.setEmailId(clientDetails.getEmailId());
		client.setLastName(clientDetails.getLastName());
		client.setFirstName(clientDetails.getFirstName());
		final Client updatedEmployee = clientRepository.save(client);
		return ResponseEntity.ok(updatedEmployee);
	}


	public Map<String, Boolean> deleteClient(Long clientId)
			throws ResourceNotFoundException {
		Client employee = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id : " + clientId));

		clientRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
