package classes;

import com.sun.jmx.snmp.Timestamp;

public class Historique {
	private int id;
	private Timestamp date_time;
	private int id_personnel;
	private int id_produit;
	private int quantite;

	//CONSTRUCTEURS
	public Historique() {
		super();
		this.id = -1;
		this.date_time = null;
		this.id_personnel = -1;
		this.id_produit = -1;
		this.quantite = -1;
	}
	public Historique(Timestamp date_time, int id_personnel, int id_produit, int quantite) {
		super();
		this.date_time = date_time;
		this.id_personnel = id_personnel;
		this.id_produit = id_produit;
		this.quantite = quantite;
	}

	public Historique(int id, Timestamp date_time, int id_personnel, int id_produit, int quantite) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.id_personnel = id_personnel;
		this.id_produit = id_produit;
		this.quantite = quantite;
	}


	//ACCESSEURS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate_time() {
		return date_time;
	}

	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}

	public int getId_personnel() {
		return id_personnel;
	}

	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


}
