package com.ipartek.formacion.nidea.ArrayListEjemplos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.nidea.util.Utilidades;

public class OrdenacionInterfacesTest {

	static ArrayList<Ordenable> coleccion;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		coleccion = new ArrayList<Ordenable>();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		coleccion = null;
	}

	@Before
	public void setUp() throws Exception {

		coleccion = new ArrayList<Ordenable>();

		Perro p1 = new Perro();
		p1.setVacunas(3);

		Mesa m2 = new Mesa();
		m2.setPatas(1);

		Perro p3 = new Perro();
		p3.setVacunas(0);

		Mesa m4 = new Mesa();
		m4.setPatas(9);

		coleccion.add(p1);
		coleccion.add(m2);
		coleccion.add(p3);
		coleccion.add(m4);

	}

	@After
	public void tearDown() throws Exception {
		coleccion = null;
	}

	@Test
	public void testBubbleSort() {

		Utilidades.bubbleSort(coleccion);

		assertEquals(0, coleccion.get(0).getValor());
		assertEquals(1, coleccion.get(1).getValor());
		assertEquals(3, coleccion.get(2).getValor());
		assertEquals(9, coleccion.get(3).getValor());

		Ordenable elemento = coleccion.get(0);

		if (elemento instanceof Perro) {
			Perro c = (Perro) elemento;

		} else if (elemento instanceof Mesa) {

			Mesa ve = (Mesa) elemento;
		} else {
			fail("No esperamos esta Clase de Objetos");
		}

	}

	@Test
	public void testCollectionSort() {
		Collections.sort(coleccion, new ComparatorOrdenables());

		assertEquals(0, coleccion.get(0).getValor());
		assertEquals(1, coleccion.get(1).getValor());
		assertEquals(3, coleccion.get(2).getValor());
		assertEquals(9, coleccion.get(3).getValor());

		Collections.reverse(coleccion);

		assertEquals(9, coleccion.get(0).getValor());
		assertEquals(3, coleccion.get(1).getValor());
		assertEquals(1, coleccion.get(2).getValor());
		assertEquals(0, coleccion.get(3).getValor());
	}

}
