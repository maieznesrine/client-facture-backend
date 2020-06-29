package tn.esprit.ClientFacture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.ClientFacture.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
