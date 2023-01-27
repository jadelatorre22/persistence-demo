package com.pluralcamp.jpd.entities;

public class Color {

	private long id = -1;
	private String name;
	private int red;
	private int green;
	private int blue;
	
	public static int MAX_VALUE = 255;
	public static int MIN_VALUE = 0;
	public static String DEFAULT_NAME = "undefined"; 
	
	public Color (String name, int red, int green, int blue) {
		this.setName(name);
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		
	}

	public Color (int red, int green, int blue) {
		this.setName(DEFAULT_NAME);
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		
	}
	
	
	public Color () {}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if(this.getId() != -1) {
			throw new UnsupportedOperationException("No se puede cambiar el id de un objeto ya asignado");
		} 
		if (id <= 0) {
			throw new IllegalArgumentException("El id a asignar a una entidad debe ser un valor positivo ");
		}
		this.id = id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name == null || name.trim().isEmpty()) {
			throw new NullPointerException("Es obligatorio el nombre del color");
		}
		this.name = name;
	}

	
	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		if(red < MIN_VALUE || red > MAX_VALUE) { 
			throw new IllegalArgumentException(String.format("Valor %d no es válido"
					+ "para las coordenadas R. " 
					+ "valores válidos: %d - %d", red, MIN_VALUE, MAX_VALUE));
		}
		this.red = red;
	}

	
	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		if(green < MIN_VALUE || green > MAX_VALUE) { 
			throw new IllegalArgumentException(String.format("Valor %d no es válido"
					+ "para las coordenadas G. " 
					+ "valores válidos: %d - %d", green, MIN_VALUE, MAX_VALUE));
		}
		this.green = green;
	}

	
	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		if(blue < MIN_VALUE || blue > MAX_VALUE) { 
			throw new IllegalArgumentException(String.format("Valor %d no es válido"
					+ "para las coordenadas B. " 
					+ "valores válidos: %d - %d", blue, MIN_VALUE, MAX_VALUE));
		}
		this.blue = blue;
	}
	
	
	
}
