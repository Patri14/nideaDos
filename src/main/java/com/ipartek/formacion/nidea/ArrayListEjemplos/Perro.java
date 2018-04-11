package com.ipartek.formacion.nidea.ArrayListEjemplos;

public class Perro implements Ordenable {

	private int vacunas;

	public Perro() {
		super();
		this.vacunas = 0;
	}

	public int getVacunas() {
		return vacunas;
	}

	public void setVacunas(int vacunas) {
		this.vacunas = vacunas;
	}

	@Override
	public String toString() {
		return "Perro [vacunas=" + vacunas + "]";
	}

	@Override
	public int getValor() {

		return getVacunas();
	}

}
