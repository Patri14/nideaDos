package com.ipartek.formacion.nidea.ArrayListEjemplos;

import java.util.ArrayList;

public class Paises {

	ArrayList<String> listaPaises = new ArrayList();

	public Paises() {
		super();
		listaPaises.add("España");
		listaPaises.add("Francia");
		listaPaises.add("Portugal");
	}

	public ArrayList<String> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(ArrayList<String> listaPaises) {
		this.listaPaises = listaPaises;
	}

	@Override
	public String toString() {
		return "Paises [listaPaises=" + listaPaises + "]";
	}

}
