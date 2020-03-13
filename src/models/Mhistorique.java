package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Historique;
import classes.Produit;

public class Mhistorique extends Dao {

	public Mhistorique() {
		super();
		this.table = "historique";
	}

	public Historique getById(int id) {
		Historique h = new Historique();
		try {
			ResultSet rs = this.conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id, date, id_personnel, id_produit, quantite FROM " + this.table + " WHERE id = " + id);
			while(rs.next()){
				h.setId(rs.getInt(1));
				h.setDate_time(rs.getTimestamp(2));
				h.setId_personnel(rs.getInt(3));
				h.setId_produit(rs.getInt(4));
				h.setQuantite(rs.getInt(5));

				Mproduit mp = new Mproduit();
				h.setNom_produit(mp.getById(rs.getInt(4)).getLibelle());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return h;
	}
	@Override
	public List<Historique> getAll() {
		List<Historique> items = new ArrayList<Historique>();
		Historique h;
		try {
	    	ResultSet rs = this.conn.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM " + this.table + " ORDER BY date DESC");
	    	while(rs.next()){
	    		h = new Historique();
	    		h.setId(rs.getInt(1));
				h.setDate_time(rs.getTimestamp(2));
				h.setId_personnel(rs.getInt(3));
				h.setId_produit(rs.getInt(4));
				h.setQuantite(rs.getInt(5));

				Mproduit mp = new Mproduit();
				h.setNom_produit(mp.getById(rs.getInt(4)).getLibelle());

				Mpersonnel mperso = new Mpersonnel();
				h.setNom_Prenom_personnel(mperso.getById(rs.getInt(3)).getNom() + " " + mperso.getById(rs.getInt(3)).getPrenom());

				items.add(h);
			}
	    	return items;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}

	public List<Historique> getPerso(int id) {
		List<Historique> items = new ArrayList<Historique>();
		Historique h;
		try {
	    	ResultSet rs = this.conn.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM " + this.table + " WHERE id_personnel = '" + id + "'");
	    	while(rs.next()){
	    		h = new Historique();
	    		h.setId(rs.getInt(1));
				//h.setDate_time(rs.getTimestamp(2));
				h.setId_personnel(rs.getInt(3));
				h.setId_produit(rs.getInt(4));
				h.setQuantite(rs.getInt(5));
				items.add(h);
			}
	    	return items;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}
