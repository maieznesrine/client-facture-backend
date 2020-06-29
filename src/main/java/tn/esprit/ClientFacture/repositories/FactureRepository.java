package tn.esprit.ClientFacture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.ClientFacture.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{
	
}
