package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

public class MaterialDAO implements Persistible<Material> {

	private static MaterialDAO INSTANCE = null;

	String sql;

	// constructor privado para que no se pueda hacer new y crear n
	// objetos(instancias)
	private MaterialDAO() {
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MaterialDAO();
		}
	}

	public static MaterialDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;

	}

	/**
	 * Recupera todos los materiales de la BBDD ordenados por id descendente
	 * 
	 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
	 */
	public ArrayList<Material> getAll() {

		ArrayList<Material> lista = new ArrayList<Material>();

		int id;
		String nombre;
		float precio;

		String sql = "SELECT id, nombre, precio FROM material;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			try (ResultSet rs = pst.executeQuery();) {

				Material m = null;
				while (rs.next()) {
					m = mapper(rs);
					lista.add(m);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return lista;
	}

	public ArrayList<Material> buscarMateriales(String search) {

		ArrayList<Material> lista = new ArrayList<Material>();

		String sql = "SELECT id, nombre, precio FROM nidea.material " + "WHERE nombre like %" + search
				+ "% ORDER BY id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			try (ResultSet rs = pst.executeQuery();) {

				Material m = null;
				while (rs.next()) {
					m = mapper(rs);
					lista.add(m);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Material getById(int id) {
		Material material = null;
		String sql = "SELECT `id`, `nombre`, `precio` FROM `material` WHERE `id` = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					material = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return material;
	}

	@Override
	public boolean save(Material material) {

		boolean result = false;

		if (material != null) {
			if (material.getId() == -1) {
				result = crear(material);
			} else {
				result = modificar(material);
			}
		}

		return result;
	}

	/**
	 * Modificar material
	 */

	private boolean modificar(Material material) {
		boolean result = false;
		String sql = "UPDATE `material` SET `nombre`=?, `precio`=? WHERE  `id`=?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, material.getNombre());// El nombre el primer interrogante, es un String.
			pst.setFloat(2, material.getPrecio());// El precio es el segundo interrogante
			pst.setFloat(3, material.getId());

			// si el numero de filas afectadas es igual a 1 es que solo he modificado un
			// registro
			// ejecuto la inserccion
			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Crear material
	 */
	private boolean crear(Material material) {
		boolean result = false;
		String sql = "INSERT INTO `material` (`nombre`, `precio`) VALUES (?, ?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, material.getNombre());// El nombre el primer interrogante, es un String.
			pst.setFloat(2, material.getPrecio());// El precio es el segundo interrogante

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				// recuperar ID generado de forma automatica
				try (ResultSet rs = pst.getGeneratedKeys()) {

					while (rs.next()) {
						material.setId(rs.getInt(1));
						// int claveGenerada = rs.getInt(1);
						result = true;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = ConnectionManager.getConnection();
			String sql = "DELETE FROM `material` WHERE `id`= ?;";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resul;
	}

	@Override
	public Material mapper(ResultSet rs) throws SQLException {
		Material m = null;
		if (rs != null) {
			m = new Material();
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("nombre"));
			m.setPrecio(rs.getFloat("precio"));

		}
		return m;
	}

}
