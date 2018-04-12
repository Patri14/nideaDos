package com.ipartek.formacion.nidea.util;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.nidea.ArrayListEjemplos.Ordenable;

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

	/**
	 * Ordenar una colecion con el algoritmo bubble sort, ordena de menor a mayor
	 * basandose en el metodo getValor de la interfaz Ordenable
	 * 
	 * @see com.ipartek.formacion.nidea.ejemplos.Ordenable
	 * @param coleccion
	 *            List<Ordenable> coleccion con los elementos a ordenadar
	 * @return en caso de null retornamos una lista vacia
	 */
	public static List<Ordenable> bubbleSort(List<Ordenable> coleccion) {
		List<Ordenable> resul = new ArrayList<Ordenable>();
		if (coleccion != null) {
			Ordenable temp;
			if (coleccion.size() > 1) // check if the number of orders is larger than 1
			{
				for (int x = 0; x < coleccion.size(); x++) // bubble sort outer loop
				{
					for (int i = 0; i < coleccion.size() - i; i++) {
						if (coleccion.get(i).getValor() > (coleccion.get(i + 1).getValor())) {
							temp = coleccion.get(i);
							coleccion.set(i, coleccion.get(i + 1));
							coleccion.set(i + 1, temp);
						}
					}
				}
			}

			resul = coleccion;
		}
		return resul;
	}

	/**
	 * if (list.size()>1) // check if the number of orders is larger than 1 { for
	 * (int x=0; x<list.size(); x++) // bubble sort outer loop { for (int i=0; i <
	 * list.size()-i; i++) { if (list.get(i).compareTo(list.get(i+1)) > 0) { temp =
	 * list.get(i); list.set(i,list.get(i+1) ); list.set(i+1, temp); } } } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
