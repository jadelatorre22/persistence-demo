package com.pluralcamp.jpd.persistence.api;

import java.util.List;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;
import com.pluralcamp.jpd.entities.Color;

public interface ColorDAO {

	public Color getColorById(long id) throws DAOException;
	public List <Color> getColors() throws DAOException;
	public List <Color> getColors(int offset, int count) throws DAOException;
	public List <Color> getColors(String searchTerm) throws DAOException;
	public List <Color> getColors(String searchTerm, int offset, int count) throws DAOException;
	
	long getNumOfColors() throws DAOException;
	
	int addColor(Color color) throws DAOException;
}
