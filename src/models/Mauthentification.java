package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Personnel;

public class Mauthentification extends Dao {

	public Mauthentification() {
		super();
		this.table = "personnel";
	}

	public Personnel checkAuth(String login, String password) {
		Personnel p = new Personnel();
		try {
			ResultSet rs = this.conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id, nom, prenom, isAdmin FROM " + this.table + " WHERE login = '" + login + "' AND passWord = '" + password +"'");
			while(rs.next()){
				p.setId(rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrenom(rs.getString(3));
				p.setIsAdmin(rs.getBoolean(4));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
