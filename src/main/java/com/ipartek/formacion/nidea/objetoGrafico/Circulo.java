package com.ipartek.formacion.nidea.objetoGrafico;

public class Circulo extends ObjetoGrafico {

	@Override
	void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimir() {
		int a = 10;
		int b = 10;

		int x = 5 - a; // x = position of x away from the center
		int y = 5 - b;
		int xSquared = (x - a) * (x - a);
		int ySquared = (y - b) * (y - b);
		for (int i = 0; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				if (Math.abs(xSquared) + (ySquared) >= 5 * 5 && Math.abs(xSquared) + (ySquared) <= 5 * 5) {
					System.out.println("#");
				} else {
					System.out.println(" ");
				}
			}

		}

	}

}
