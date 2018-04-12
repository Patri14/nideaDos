package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUserController
 */
@WebServlet("LoginUserController")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// parámetros
	private int id;
	private String nombre;

	private RequestDispatcher dispatcher;

	private static final String VIEW_BIENVENIDA = "bienvenidaUser.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// recoger los parámetros
			recogerParametros(request);

			// recojo los usuarios conectados
			ServletContext aplicacion = request.getServletContext();

			HashMap<Integer, String> usuarios = (HashMap<Integer, String>) aplicacion
					.getAttribute("usuarios_conectados");
			// pilla atributos

			// la primera vez que entro me crea el HasMap, porque usuarios es null
			if (usuarios == null) {
				usuarios = new HashMap<Integer, String>();
			}

			usuarios.put(id, "nombre");// meto al usuario dentro del hasMap

			aplicacion.setAttribute("usuarios_conectados", usuarios);// guardo el hashMap en el contexto servlet

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			request.getRequestDispatcher(VIEW_BIENVENIDA).forward(request, response);

		}

	}

	private void recogerParametros(HttpServletRequest request) {

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
	}

}
