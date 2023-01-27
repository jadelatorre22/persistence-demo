package com.pluralcamp.jpd.persistence.providers.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pluralcamp.jpd.entities.Color;
import com.pluralcamp.jpd.persistence.api.ColorDAO;
import com.pluralcamp.jpd.persistence.exceptions.DAOException;

public class ColorDAOJDBCImpl implements ColorDAO {

	@Override
	public Color getColorById(long id) throws DAOException {
		Color color = null;
		
		//Paso 1: Obtener una conexion con la base de datos
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Oslo";
		String username = "jadelatorre22";
		String password = "pluralcamp";
		String query = "SELECT id, name, red, green, blue FROM colors WHERE id =?";
		Connection connection = null;
		//Paso 2: Crear statement (canal para enviar una query)
		PreparedStatement sentSQL = null;
		//Paso 3: Crear un canal para leer el resultado (respuesta a mi query)
		ResultSet reader = null;
		try {
		connection = DriverManager.getConnection(url, username, password);
		sentSQL = connection.prepareStatement(query);
		sentSQL.setLong(1, id);
		reader = sentSQL.executeQuery();
		if(reader.next());
				//ORM: mapear la fila con un objeto de tipo color
		color = getColorFrom(reader);
		
		} catch (SQLException ex) {
			throw new DAOException(ex);
		} finally { //Cerrar la conexion 
			try {
			reader.close();
			sentSQL.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return color;
	}

	private Color getColorFrom(ResultSet reader) throws SQLException {
		var color = new Color(reader.getString("name"), reader.getInt("red"),  
				reader.getInt("green"), reader.getInt("blue"));
				color.setId(reader.getLong("id"));
				return color;
		
	}
	

	@Override
	public List<Color> getColors() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors(int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors(String searchTerm) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumOfColors() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addColor(Color color) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
