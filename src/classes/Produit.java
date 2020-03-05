package classes;

import java.sql.Timestamp;

import models.Mhistorique;
import models.Mproduit;

public class Produit {
	private int id;
	private String libelle;
	private int quantite;
	private String description;

	//CONSTRUCTEUR
	public Produit() {
		super();
		this.id = -1;
		this.libelle = null;
		this.quantite = -1;
		this.description = null;
	}
	public Produit(String libelle, int quantite, String description) {
		super();
		this.libelle = libelle;
		this.quantite = quantite;
		this.description = description;
	}
	public Produit(int id, String libelle, int quantite, String description) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.quantite = quantite;
		this.description = description;
	}


	//METHODE
	public void addQteProduit(int qte) {
		Mproduit mp = new Mproduit();

		this.quantite+=qte;
		Object[] tabValues = {this.description, this.libelle, this.quantite, this.id};
		mp.update(tabValues);
	}

	public void subQteProduit(int qte, int idUser) {
		if(this.quantite-qte>=0){
			Mproduit mp = new Mproduit();
			Mhistorique mh = new Mhistorique();

			this.quantite-=qte;
			Object[] tabValues = {this.description, this.libelle, this.quantite, this.id};
			mp.update(tabValues);
			Object[] tabValuesHistorique = {new Timestamp(System.currentTimeMillis()), idUser, this.id, qte};//date, id_personnel, id_produit, quantite
			mh.add(tabValuesHistorique);
		} else {
			System.out.println("Impossible de laisser le stock en dessous de 0");
		}
	}

	//ACCESSEUR
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		//return "Produit [id=" + id + ", libelle=" + libelle + ", quantite=" + quantite + ", description=" + description + "]";
		return libelle;
	}



}
