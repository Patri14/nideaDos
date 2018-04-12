package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController2
 */
@WebServlet("/Login2")
public class LoginController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = "";

	private static final String USER = "";
	private static final String ID = "";

	private static final int SESSION_EXPIRATION = 60 * 1;

	public LoginController2() {
		super();

	}

	/**
	 * get
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	/**
	 * post
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String nombre = request.getParameter("nombre");
			String id = request.getParameter("id");

			// guardar usuario en sesión
			HttpSession session = request.getSession();
			session.setAttribute("usuario", nombre);

			session.setMaxInactiveInterval(SESSION_EXPIRATION);

			view = "form2.jsp";

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
