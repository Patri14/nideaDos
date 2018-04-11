package com.ipartek.formacion.nidea.objetoGrafico;

public class Rectangulo extends ObjetoGrafico {

	@Override
	void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimir() {
		char espacio = ' ';
		char asterisco = '*';
		for (int i = 1; i <= 5; i++) {
			for (int espacios = 5 - i; espacios > 0; espacios--)
				System.out.print(espacio);
			for (int lineas = 1; lineas < 2 * i; lineas++)
				System.out.print(asterisco);
			System.out.println("");
		}
		for (int i = 4; i >= 1; i--) {
			for (int espacios = 5 - i; espacios > 0; espacios--)
				System.out.print(espacio);
			for (int lineas = 1; lineas < 2 * i; lineas++)
				System.out.print(asterisco);
			System.out.println("");
		}
	}

}
