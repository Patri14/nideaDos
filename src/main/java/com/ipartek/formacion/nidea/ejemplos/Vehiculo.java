package com.ipartek.formacion.nidea.ejemplos;

public class Vehiculo {

	private int puertas;
	private String color;

	public Vehiculo() {
		super(); // llama a java.lang.object
		this.puertas = 3; // por defecto el coche tiene 3 puertas
		this.color = "blanco";
		System.out.println("Instanciado vehículo nuevo");
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void arrancar() {
		System.out.println("Introducir llave y girar");
	}

	@Override
	public String toString() {
		return "Vehiculo [puertas=" + puertas + ", color=" + color + "]";
	}

}
