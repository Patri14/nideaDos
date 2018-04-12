package com.ipartek.formacion.nidea.ArrayListEjemplos;

import java.util.Comparator;

public class ComparatorOrdenables implements Comparator<Ordenable> {

	@Override
	public int compare(Ordenable o1, Ordenable o2) {
		// TODO Auto-generated method stub
		return o1.getValor() - o2.getValor();
	}

}
