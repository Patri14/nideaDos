package com.ipartek.formacion.nidea.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class BackofficeFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, description = "Dejar pasar solo a los usuarios Logeados", urlPatterns = {
				"/backoffice/*" })

// todo lo que vaya a backoffice a cualquier servleto jsp, tiene que pasar por
// este filtro
public class BackofficeFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("BackofficeFilter destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// casteamos de ServletRequest a HttpServletRequest, y lo mismo con
		// ServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		if (null != session.getAttribute("usuario")) {
			chain.doFilter(request, response);
		} else {
			informacionPeticion(req);
			res.sendRedirect(req.getContextPath() + "/login");
		}

	}

	/**
	 * Mostramos por pantalla toda la informacion del Usuario == Request
	 */
	private void informacionPeticion(HttpServletRequest req) {
		System.out.println("*************************************");
		System.out.println("********ACCESO NO PERMITIDO**********");
		System.out.println("IP= " + req.getLocalAddr());
		System.out.println("PUERTO= " + req.getRemotePort());
		System.out.println("URI= " + req.getContextPath());
		System.out.println("URL= " + req.getRequestURL());
		System.out.println("*************************************");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("BackofficeFilter init()");
	}

}
