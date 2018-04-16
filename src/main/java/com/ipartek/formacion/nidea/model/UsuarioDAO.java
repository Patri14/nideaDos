package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Usuario;
import com.ipartek.formacion.nidea.util.Utilidades;

public class UsuarioDAO implements Persistible<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	String sql;

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;

	}

	/**
	 * Recupera todos los USUARIOS de la BBDD ordenados por id descendente
	 * 
	 * @return ArrayList<Usuario> si no existen registros new ArrayList<Usuario>()
	 */
	@Override
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> listaUser = new ArrayList<Usuario>();

		int id;
		String nombre;
		String password;

		String sql = "SELECT id, nombre, password FROM usuario;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			try (ResultSet rs = pst.executeQuery();) {

				Usuario u = null;
				while (rs.next()) {
					u = mapper(rs);
					listaUser.add(u);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaUser;
	}

	/**
	 * CREAR USUARIO
	 */
	private boolean crear(Usuario usuario) throws SQLIntegrityConstraintViolationException {
		boolean result = false;
		String sql = "INSERT INTO `usuario` (`nombre`, `password`) VALUES (?, ?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getPassword());
			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				// recuperar ID generado de forma automatica
				try (ResultSet rs = pst.getGeneratedKeys()) {

					while (rs.next()) {
						usuario.setId(rs.getInt(1));
						result = true;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * RECOGER POR ID
	 */
	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		String sql = "SELECT `id`, `nombre`, `password` FROM `usuario` WHERE `id` = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					usuario = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * GUARDAR
	 */
	@Override
	public boolean save(Usuario usuario) throws SQLIntegrityConstraintViolationException {
		boolean result = false;

		// sanear el nombre
		usuario.setNombre(Utilidades.limpiarEspacios(usuario.getNombre()));

		if (usuario != null) {
			if (usuario.getId() == -1) {
				result = crear(usuario);
			} else {
				result = modificar(usuario);
			}
		}

		return result;
	}

	/**
	 * MODIFICAR
	 */
	private boolean modificar(Usuario usuario) {
		boolean result = false;
		String sql = "UPDATE `usuario` SET `nombre`=?, `password`=? WHERE  `id`=?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getPassword());
			pst.setInt(3, usuario.getId());

			// si el numero de filas afectadas es igual a 1 es que solo he modificado un
			// registro ejecuto la inserccion
			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		String sql = "DELETE FROM `usuario` WHERE `id`= ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario m = null;
		if (rs != null) {
			m = new Usuario();
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("nombre"));
			m.setPassword(rs.getString("password"));

		}
		return m;
	}

}
