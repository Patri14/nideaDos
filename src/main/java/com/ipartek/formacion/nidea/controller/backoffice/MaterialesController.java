package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class MaterialesController
 */

@WebServlet("/backoffice/materiales")
public class MaterialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INDEX = "materiales/index.jsp";
	private static final String VIEW_FORM = "materiales/form.jsp";

	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	// crear o modificar id -1 es que es creado, si existe el id es modificar
	public static final int OP_GUARDAR = 2;

	private RequestDispatcher dispatcher;
	private Alert alert;
	private MaterialDAO dao;

	// parámetros comunes
	private String search; // buscador por nombre material
	private int op; // operacion a realizar

	// parámetros del material
	private int id;
	private String nombre;
	private String sPrecio;
	private float precio;

	// se ejecuta solo la primera vez que se llama al servlet
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// para que se cargue el dao la primera vez
		dao = MaterialDAO.getInstance();
	}

	// se ejecuta cuando paramos el servidor de aplicaciones
	public void destroy() {
		super.destroy();
		dao = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("antes de ejecutar doGet() o doPost()");
		super.service(request, response); // llama a doGet() o a doPOst()
		// System.out.println("despues de ejecutar doGet() o doPost()");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	/**
	 * Unimos las peticiones doGet y doPost, vamos, que hacemos lo mismo
	 * 
	 * @param request
	 * @param response
	 */

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = null;

		try {

			// recoger los parámetros
			recogerParametros(request);

			switch (op) {
			case OP_MOSTRAR_FORMULARIO:
				mostrarFormulario(request);
				break;
			case OP_ELIMINAR:
				eliminar(request, response);
				break;
			case OP_BUSQUEDA:
				buscar(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;
			default:
				listar(request);
				break;
			}

			// ArrayList<Material> materiales = new ArrayList<Material>();
			// String search = request.getParameter("search");
			// System.out.println("filtro de busqueda= " + search);

			// enviar como atributo la lista de materiales
			// MaterialDAO dao = MaterialDAO.getInstance();
			// materiales = dao.getAll();

			// dispatcher = request.getRequestDispatcher(VIEW_INDEX);
			// materiales = dao.buscarMateriales(search);

		} catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();

		} finally {
			op = 0;

			request.setAttribute("alert", alert);
			// quest.setAttribute("materiales", materiales);
			dispatcher.forward(request, response);
		}

	}

	/**
	 * Creamos un nuevo material si su id es igual a -1 Modificamos un material en
	 * caso contrario Y actualizamos el listado llamando al metodo
	 * actualizarMaterial()
	 */
	private void guardar(HttpServletRequest request) {
		Material material = new Material();
		try {

			material.setId(id);
			material.setNombre(nombre);
			precio = Float.parseFloat(sPrecio);
			material.setPrecio(precio);

			if (precio < 0) {

				alert = new Alert("Introduce un precio mayor que 0", Alert.TIPO_WARNING);

			} else if (nombre == null || nombre.isEmpty()) {

				alert = new Alert("Introduce un nombre para este material", Alert.TIPO_WARNING);

			} else if (nombre.length() > 45) {

				alert = new Alert("El nombre que has introducido es demasiado largo", Alert.TIPO_WARNING);

			} else {

				if (id == -1) {
					if (dao.save(material)) {
						alert = new Alert("Material nuevo guardado", Alert.TIPO_PRIMARY);
					} else {
						alert = new Alert("No se puedo guardar el nuevo material", Alert.TIPO_WARNING);
					}
				} else {
					if (dao.save(material)) {
						alert = new Alert("Modificado material con id " + id, Alert.TIPO_PRIMARY);
					} else {
						alert = new Alert("No se puedo modificar el material", Alert.TIPO_WARNING);
					}
				} // fin else material modificado
			} // fin save material

		} catch (SQLIntegrityConstraintViolationException e) {

			alert = new Alert("El material ya existe en la base de datos", Alert.TIPO_WARNING);
		}

		catch (NumberFormatException e) {

			alert = new Alert("El formato de precio no puede contener letras", Alert.TIPO_WARNING);
		}

		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}// fin guardar()

	/**
	 * Busqueda de materiales por nombre
	 */
	private void buscar(HttpServletRequest request) {

		alert = new Alert("Busqueda para: " + search, Alert.TIPO_PRIMARY);
		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = dao.buscarMateriales(search);
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		if (dao.delete(id)) {
			alert = new Alert("Material Eliminado id " + id, Alert.TIPO_PRIMARY);
			// para que nos varie del logout a login en la url

		} else {
			alert = new Alert("Error Eliminando, sentimos las molestias ", Alert.TIPO_WARNING);
		}
		listar(request);
	}

	private void modificar(HttpServletRequest request) {
		if (id > -1) {
			alert = new Alert("Modifico este " + id, Alert.TIPO_WARNING);
		} else {
			alert = new Alert("Guardo este nuevo " + id, Alert.TIPO_WARNING);
		}
	}

	private void mostrarFormulario(HttpServletRequest request) {

		Material material = new Material();
		if (id > -1) {

			// TODO recuperar de la BBDD que es un material que existe
			alert = new Alert("Estoy en mostrar formulario Mostramos Detalle id:" + id, Alert.TIPO_WARNING);
			material = dao.getById(id);

		} else {
			alert = new Alert("Nuevo Producto", Alert.TIPO_WARNING);

		}
		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void listar(HttpServletRequest request) {

		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = dao.getAll();
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void recogerParametros(HttpServletRequest request) {

		if (request.getParameter("op") != null) {
			op = Integer.parseInt(request.getParameter("op"));
		} else {
			op = 0;
		}

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		} else {
			id = -1;
		}

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre").trim();

		} else {
			nombre = "";
		}

		if (request.getParameter("precio") != null) {
			sPrecio = request.getParameter("precio");
		}
	}

}
