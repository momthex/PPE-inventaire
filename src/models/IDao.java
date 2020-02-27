package models;

import java.util.List;

public interface IDao<T> {
	List<Object> getAll();
	Object getById(int id);

	boolean add(Object[] tabValues);
	boolean update(Object[] tabValues);
	boolean delete(int id);
	List<String> getColonnes();
}
