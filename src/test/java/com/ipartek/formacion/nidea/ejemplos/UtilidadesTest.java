package com.ipartek.formacion.nidea.ejemplos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilidadesTest {

	@Test
	public void testLimpiarEspacios() {

		assertEquals("Hola que haces", Utilidades.limpiarEspacios("   Hola que    haces  "));
		assertEquals("", Utilidades.limpiarEspacios(null));
	}

}
