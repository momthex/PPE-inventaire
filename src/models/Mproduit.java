package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Produit;

public class Mproduit extends Dao {

	public Mproduit() {
		super();
		this.table = "produit";
	}
}
