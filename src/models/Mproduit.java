package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import classes.Produit;

public class Mproduit extends Dao {

	public Mproduit() {
		super();
		this.table = "produit";
	}

	public Produit getById(int id) {
		Produit p = new Produit();
		try {
			ResultSet rs = this.conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id, libelle, quantite, description FROM " + this.table + " WHERE id = " + id);
			while(rs.next()){
				p.setId(rs.getInt(1));
				p.setLibelle(rs.getString(2));
				p.setQuantite(rs.getInt(3));
				p.setDescription(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
