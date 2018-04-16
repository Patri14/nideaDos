package com.ipartek.formacion.nidea.pojo;

public class Usuario {

	private int id;
	private String nombre;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Usuario(int id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ususario [id=" + id + ", nombre=" + nombre + "]";
	}

}
