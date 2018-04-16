package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Servlet implementation class loginUserController
 */
@WebServlet("/login-user")
public class loginUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private HashMap<Integer, String> usuarios = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarios = new HashMap<Integer, String>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			Usuario usuario = new Usuario(id, nombre);

			HttpSession session = request.getSession();// salta el listener sessionCreated
			session.setMaxInactiveInterval(5);// en 5 segundos se destruye
			session.setAttribute("uPublic", usuario);// salta el listener attributeAdded
			// recoger parametros
			// int id = Integer.parseInt(request.getParameter("id"));
			// String nombre = request.getParameter("usuario");
			//
			// // recoger usuarios_conectados del ServletContext
			// ServletContext ctx = request.getServletContext();
			//
			// if (ctx.getAttribute("usuarios_conectados") == null) {
			// usuarios = new HashMap<Integer, String>();
			// } else {
			// usuarios = (HashMap<Integer, String>)
			// ctx.getAttribute("usuarios_conectados");
			// }

			// guardar usuario en hashmap
			// usuarios.put(id, nombre);

			// guardar hasmap en contexto Servlets
			// ctx.setAttribute("usuarios_conectados", usuarios);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			request.getRequestDispatcher("/bienvenidaUser.jsp").forward(request, response);
		}

	}

}
