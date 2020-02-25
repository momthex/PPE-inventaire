package models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

public abstract class Dao<T> implements IDao<T> {

	Connection conn;
	String table;

	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER OK ! ");

            String url = "jdbc:mysql://localhost:3308/gsb_inventaire";

            conn = (Connection) DriverManager.getConnection(url,"root","");
            System.out.println("Connection effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<T> getAll() {
		List<T> items = null;

		return items;
	}

	@Override
	public T getById(int id) {
		T obj = null;

		try {
	    	ResultSet result = this.conn.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM produit WHERE id = " + id);
	    	if(result.first()){
	    		//obj = (T)new Object(result.getInt("id"), result.getString("libelle"), result.getInt("quantite"), result.getString("description"));
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
		return obj;
	}

	@Override
	public T add(T item) {

		return item;
	}

	@Override
	public T update(T item) {

		return item;
	}

	@Override
	public boolean delete(T item) {
		try {

		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
