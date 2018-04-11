package com.ipartek.formacion.nidea.objetoGrafico;

abstract class ObjetoGrafico implements Imprimible {
	private int x;
	private int y;

	void mover(int x, int y) {
		this.x = x;
		this.y = y;
	}

	abstract void dibujar();
}
