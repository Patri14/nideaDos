package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet("/materiales")
public class MaterialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// por si no entra en el try creamos estos oBjetos
		ArrayList<Material> materiales = new ArrayList<Material>();
		Alert alert = null;
		String search = request.getParameter("search");

		try {

			// enviar como atributo la lista de materiales
			MaterialDAO dao = MaterialDAO.getInstance();
			materiales = dao.getAll();
			view = "materiales.jsp";

		} catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();

		} finally {
			request.setAttribute("alert", alert);
			request.setAttribute("materiales", materiales);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
