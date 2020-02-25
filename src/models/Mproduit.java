package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Produit;

public class Mproduit<Produit> extends Dao<Produit> {

	public Mproduit() {
		super();
		this.table = "produit";
	}

	/*public Produit find(int id) {
		Produit produit = new Produit();

		try {
	    	ResultSet result = this.conn.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM produit WHERE id = " + id);
	    	if(result.first()){
	    		produit = new Produit(result.getInt("id"), result.getString("libelle"), result.getInt("quantite"), result.getString("description"));
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return produit;
	  }*/

	public Produit getById(int id) {
		
		return null;
	}
}
