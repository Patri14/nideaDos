package com.ipartek.formacion.nidea.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Persistible<P> {

	/**
	 * Lista de una tabla de la bbdd ordenado por id y limitado a 500
	 * 
	 * @return colección
	 */
	public ArrayList<P> getAll();

	/**
	 * obtenemos el detalle de un registro
	 * 
	 * @param id
	 *            identificador
	 * @return registro si exite, null en caso contrario
	 */
	public P getById(int id);

	/**
	 * Guardamos un registro en la BBDD<br>
	 * si el id del pojo == -1 Creamos<br>
	 * si el id del pojo > 1 Modificamos
	 * 
	 * @param pojo
	 * @return
	 */
	public boolean save(P pojo);

	/**
	 * Eliminamos un registro por su id
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * Nos mapea un resultado de la bbdd a un POJO
	 * 
	 * @param rs
	 *            ResultSet 1 registro de la consulta
	 * @return devuelve un POJO con los valores de ResultSet o null si no hay
	 *         valores
	 */
	public P mapper(ResultSet rs) throws SQLException;
}
