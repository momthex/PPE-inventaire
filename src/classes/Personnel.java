package classes;

public class Personnel {
	private int id;
	private String nom;
	private String prenom;
	private Boolean isAdmin;

	//CONSTRUCTEUR
	public Personnel() {
		super();
		this.id = -1;
		this.nom = null;
		this.prenom = null;
		this.isAdmin = false;
	}
	public Personnel(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	//ACCESSEURS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
