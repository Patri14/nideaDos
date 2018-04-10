package com.ipartek.formacion.nidea.ejemplos;

public class Utilidades {

	/**
	 * Método estático para poder usarse desd la misma clase<br>
	 * sin tener que instanciar un objeto<br>
	 * límpia los carácteres vacios de una cadena, hacemos trim()<br>
	 * además sustituir todos los espacios en blanco por una único<br>
	 *
	 * Pe: " Hola que haces " lo sustituye por "Hola que haces"
	 *
	 * @return en caso de null devuelve cadena vacía
	 */
	public static String limpiarEspacios(String cadena) {

		if (cadena != null) {

			cadena = cadena.replaceAll(" +", " ").trim();

		} else {

			cadena = "";
		}

		return cadena;

	}
}
