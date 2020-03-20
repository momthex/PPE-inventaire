package models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import classes.Personnel;

public class Mauthentification extends Dao {

	public Mauthentification() {
		super();
		this.table = "personnel";
	}

	public Personnel checkAuth(String login, String password) throws NoSuchAlgorithmException {
		Personnel p = new Personnel();
		try {
			//Hash du mot de passe
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }



			ResultSet rs = this.conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id, nom, prenom, isAdmin FROM " + this.table + " WHERE login = '" + login + "' AND passWord = '" + hexString.toString() +"'");
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
