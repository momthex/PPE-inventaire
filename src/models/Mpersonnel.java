package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Personnel;
import classes.Produit;

public class Mpersonnel extends Dao {

	public Mpersonnel(){
		super();
		this.table = "personnel";
	}

	public Personnel getById(int id) {
		Personnel p = new Personnel();
		try {
			ResultSet rs = this.conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id, isAdmin, nom, prenom FROM " + this.table + " WHERE id = " + id);
			while(rs.next()){
				p.setId(rs.getInt(1));
				p.setIsAdmin(rs.getBoolean(2));
				p.setNom(rs.getString(3));
				p.setPrenom(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return p;
	}
}
