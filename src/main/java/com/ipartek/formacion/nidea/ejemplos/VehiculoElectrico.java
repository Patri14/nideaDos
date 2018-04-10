package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo {

	private float potencia; // en Kw

	public VehiculoElectrico() {
		super(); // es Vehiculo
		this.potencia = 0;
		System.out.println("Instaciado vehículo eléctrico");
	}

	// sobrecarga del constructor
	public VehiculoElectrico(float potencia) {
		this();// para que llame al constructor de esta misma clase se cambia super por this
		this.potencia = potencia;
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	// Sobreescribimos el método arrancar del padre, es polimorfismo también
	@Override
	public void arrancar() {
		// super.aarancar();
		System.out.println("Pulsar botón encendido");
	}

	@Override
	public String toString() {
		return super.toString() + " \n VehiculoElectrico [potencia=" + potencia + "]";
	}

}
