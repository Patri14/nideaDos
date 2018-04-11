package com.ipartek.formacion.nidea.ArrayListEjemplos;

public class Mesa implements Ordenable {

	private int patas;

	public Mesa() {
		super();
		this.patas = 0;
	}

	public int getPatas() {
		return patas;
	}

	public void setPatas(int patas) {
		this.patas = patas;
	}

	@Override
	public String toString() {
		return "Mesa [patas=" + patas + "]";
	}

	@Override
	public int getValor() {

		return getPatas();
	}

}
