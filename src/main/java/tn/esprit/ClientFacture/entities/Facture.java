package tn.esprit.ClientFacture.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Facture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String reference;
	private double montant;
	private String description; 
	private Date date;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "client_id",referencedColumnName = "id")
	@JsonBackReference
	private Client client;
	
	
	public Facture() {
	}
	public Facture(String reference, double montant, String description, Date date, Client client) {
		this.reference = reference;
		this.montant = montant;
		this.description = description;
		this.date = date;
		this.client = client;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Facture [id=" + id + ", reference=" + reference + ", montant=" + montant + ", description="
				+ description + ", date=" + date + ", client=" + client + "]";
	}

	
}
