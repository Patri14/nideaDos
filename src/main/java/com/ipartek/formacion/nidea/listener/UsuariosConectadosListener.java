package com.ipartek.formacion.nidea.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * HttpSessionListener: ciclo vida sesión HttpSessionAttributeListene: ciclo
 * vida atributo
 */
@WebListener
public class UsuariosConectadosListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * sessionCreated
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	/**
	 * sessionDestroyed
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	/**
	 * attributeAdded
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {

		// comprobar que sea atributo == uPublic
		if (event.getName().equals("uPublic")) {

			// contexto de la app
			ServletContext ctx = event.getSession().getServletContext();

			HashMap<Integer, Usuario> hmUsuarios = (HashMap<Integer, Usuario>) ctx.getAttribute("usuarios_conectados");
			// coge atributos

			// la primera vez que entro me crea el HasMap, porque usuarios es null
			if (hmUsuarios == null) {
				hmUsuarios = new HashMap<Integer, Usuario>();
			}
			Usuario user = (Usuario) event.getValue();

			hmUsuarios.put(user.getId(), user);// meto al usuario dentro del hasMap

			ctx.setAttribute("usuarios_conectados", hmUsuarios);// guardo el hashMap en el contexto servlet

		}

	}

	/**
	 * attributeRemoved
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {

	}

	/**
	 * attributeReplaced
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

}
