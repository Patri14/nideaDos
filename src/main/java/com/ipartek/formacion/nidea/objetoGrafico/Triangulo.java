package com.ipartek.formacion.nidea.objetoGrafico;

public class Triangulo extends ObjetoGrafico {

	@Override
	void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimir() {
		int n;
		String triangulo = "";

		n = 12;

		for (int i = 1; i <= n; i++) {
			triangulo = triangulo + "*";
			System.out.println(triangulo);
		}

	}

}
