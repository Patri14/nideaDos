package com.ipartek.formacion.nidea.ejemplos;

public class EjercicioVehiculos {

	public static void main(String[] args) {
		// NO SE PUEDEN CREAR OBJETOS DE UNA CLASE ABSTRACTA
		// Vehiculo rayoMcQueen = new Vehiculo();
		// System.out.println("Soy RAYOMcQEEN " + rayoMcQueen.toString());

		System.out.println("------------------------------------");

		VehiculoElectrico tesla = new VehiculoElectrico();
		System.out.println("Soy TESLA " + tesla.toString());

		System.out.println("Heredo color de mi padre= " + tesla.getColor());

	}

}
