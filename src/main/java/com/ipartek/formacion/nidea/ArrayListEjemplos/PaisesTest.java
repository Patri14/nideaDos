package com.ipartek.formacion.nidea.ArrayListEjemplos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class PaisesTest {

	@Test
	public void testArrayList() {
		ArrayList<String> listaPaises = new ArrayList();

		// Metodo add. añade elementos a nuestra lista
		listaPaises.add("España");
		listaPaises.add("Francia");
		listaPaises.add("Portugal");

		// Metodo get, devolvemos un elemento de un indice
		// listaPaises.get(0); => Primer elemento

		assertEquals("España", listaPaises.get(0));
		assertEquals("Francia", listaPaises.get(1));
		assertEquals("Portugal", listaPaises.get(2));

		// Metodo remove, elimina elementos de nuestra lista mediente indice

		listaPaises.remove(2); // Elimino el ultimo elemento, no el elemento 2

		assertEquals(null, listaPaises.get(2));

		// Metodo size, indica el numero de elementos de la lista

		listaPaises.size();

		// Metodo Iterator, util para recorrer un arrayList

		Iterator<String> it = listaPaises.iterator();
		String num;
		while (it.hasNext()) {
			num = it.next();
		}

		// Metodo indexOf, util para saber la posicion de un elemento

		listaPaises.indexOf(1);

		// Metodo Clear, elimina todos los elementos
		listaPaises.clear();

		// Metodo isEmpty, indica si un arraylist esta vacio o no

		listaPaises.isEmpty();
	}

}
