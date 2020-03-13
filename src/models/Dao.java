package models;

import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.sun.jmx.snmp.Timestamp;
import com.sun.xml.internal.ws.util.StringUtils;

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
	public List<Object> getAll() {
		List<Object> items = null;
		Object obj = null;

		/*try {
	    	ResultSet result = this.conn.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM " + this.table);
	    	if(result.first()){
	    		obj = creatObj("Produit", VALEUR A RENTRER);
	    		items.add(obj);
	    	}
	    	return items;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }*/
		return null;
	}

	@Override
	public Object getById(int id) {
		Object obj = null;
		ResultSetMetaData rsmd = null;

		try {
			ArrayList al = new ArrayList();
			ResultSet result = this.conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM " + this.table + " WHERE id = " + id);

			if(result.first()){
				rsmd = (ResultSetMetaData) result.getMetaData();
				Object[] tabValues = new Object[rsmd.getColumnCount()];
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					tabValues[i-1] = result.getObject(i);
				}
				al.add(tabValues);
				//obj = creatObj("Produit", al);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * Met à jour le niveau du membre.
	 *
	 * @param tabValues
	 *            Ordre dans le tableau : -> Description -> Libellé -> Quantité
	 */
	@Override
	public boolean add(Object[] tabValues) {
		List<String> colonnes = getColonnes();
		String SQL = "INSERT INTO " + this.table + " (";

		//Preparation de la requete SQL
		for (String colonne : colonnes) {
			SQL += colonne + ", ";
		}
		SQL = SQL.substring(0, SQL.length() - 2);
		SQL += ") VALUES (";
		for (int i = 1; i <= tabValues.length; i++) {
			SQL += "?, ";
		}
		SQL = SQL.substring(0, SQL.length() - 2);
		SQL += ")";
		System.out.println(SQL);

		//Remplissage de la requete SQL
		try {
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(SQL);
			for (int i = 1; i <= tabValues.length; i++) {
				st.setObject(i, tabValues[i - 1]);
			}
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Met à jour le niveau du membre.
	 *
	 * @param tabValues
	 *            Ordre dans le tableau :-> Description -> Libellé -> Quantité -> Id
	 */
	@Override
	public boolean update(Object[] tabValues) {
		List<String> colonnes = getColonnes();
		String SQL = "UPDATE " + this.table + " SET ";

		//Preparation de la requete SQL
		for (String colonne : colonnes) {
			SQL += colonne + " = ?, ";
		}
		SQL = SQL.substring(0, SQL.length() - 2);
		SQL += " WHERE id = ?;";

		//Remplissage de la requete SQL
		try {
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(SQL);
			for (int i = 1; i <= tabValues.length; i++) {
				st.setObject(i, tabValues[i - 1]);
			}
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		String SQL = "DELETE FROM " + this.table + " WHERE id = " + id;
		try {
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(SQL);
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Récupere les colonnes de la table
	public List<String> getColonnes(){
		List<String> listeColonne = new ArrayList<String>();
		String SQL = "select COLUMN_NAME, COLUMN_TYPE from INFORMATION_SCHEMA.COLUMNS where table_name='" + this.table +"' AND table_schema='gsb_inventaire' AND COLUMN_NAME<>'id';";

		ResultSet rs;
		try {
			rs = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(SQL);
			while (rs.next()) {
				listeColonne.add(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listeColonne;
	}

	//Reflextion
	public Object creatObj(String typeClass, ArrayList tabValues){
		String class_name="classes."+typeClass;
		try
		{
			Class<?> cls = Class.forName(class_name);
			Object obj = cls.newInstance();

			Method[] methods =  cls.getDeclaredMethods();
			List<Method> mSet = new ArrayList<>();

			//Récupération des setters
			for( int i = 0 ; i < methods.length ; i++ ) {
				if(methods[i].getName().startsWith("set")) {
					mSet.add(methods[i]);
				}
			}

			for (int f = 0; f < tabValues.size(); f++) {
				Object[] val = (Object[]) tabValues.get(f);
				for (Method method : mSet) {
					int e = 0;
					List<String> tabName = getColonnes();
					tabName.add("Id");
					for (String name : tabName) {
						System.out.println(name);
						if(method.getName().contains((CharSequence) StringUtils.capitalize(name))){
							if(val[e].getClass() == Integer.class) {
								method = cls.getMethod(method.getName(), new Class[] {int.class} );
								method.invoke(obj, new Object[] {val[e]});
							} else if (val[e].getClass() == String.class) {
								method = cls.getMethod(method.getName(), new Class[] {String.class} );
								method.invoke(obj, new Object[] {val[e]});
							} else if (val[e].getClass() == Timestamp.class){
								method = cls.getMethod(method.getName(), new Class[] {Timestamp.class} );
							}
						}
						e++;
					}
				}
			}

			System.out.println("*****************");
			System.out.println(obj+" "+obj.getClass().getSimpleName());
			return obj;
		}
		catch( Exception e )
		{
			e.printStackTrace();
			return null;
		}
	}
}