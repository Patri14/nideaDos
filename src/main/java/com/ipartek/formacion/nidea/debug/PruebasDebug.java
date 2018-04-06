package com.ipartek.formacion.nidea.debug;

public class PruebasDebug {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}

		metodoA();

	}

	private static void metodoA() {
		System.out.println("soy el método A y llamo al método B");
		metodoB();
	}

	private static void metodoB() {
		System.out.println("soy el método B y llamo al método C");
		metodoC();

	}

	private static void metodoC() {
		System.out.println("soy el método C y llamo a un  método de otra clase");

		Utilidades util = new Utilidades();
		util.diaHoy();

	}

}
