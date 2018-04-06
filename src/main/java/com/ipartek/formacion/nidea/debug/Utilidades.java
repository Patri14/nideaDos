package com.ipartek.formacion.nidea.debug;

import java.util.Calendar;

public class Utilidades {

	public String[] diaHoy() {
		// Creamos una instancia del calendario
		Calendar now = Calendar.getInstance();

		System.out.println("Fecha actual : " + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE) + "-"
				+ now.get(Calendar.YEAR));

		// Array con los dias de la semana
		String[] diasSemana = new String[] { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };

		// El dia de la semana inicia en el 1 mientras que el array empieza en el 0
		System.out.println("Hoy es : " + diasSemana[now.get(Calendar.DAY_OF_WEEK) - 1]);
		return diasSemana;

	}

}
