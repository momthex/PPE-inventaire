package classes;

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
		this.quantite+=qte;
	}

	public void subQteProduit(int qte) {
		this.quantite-=qte;
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
