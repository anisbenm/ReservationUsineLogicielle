package reservation.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import reservation.entity.Utilisateur;

/**
 * Interceptor de l'application Web de Gestion d'Hotel
 * 
 * @author formation
 *
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = Logger.getLogger(AccessInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("Utilisateur") ;
		logger.error("preHandle URI:"+uri+" User:"+user);
		if ( user != null && user.getId() > 0 ){
			return true;
		}else if ( 	uri.endsWith("home") || uri.endsWith("/") ||
					uri.endsWith("identification") ||
					uri.endsWith("inscription")){
			return true;
		}else{
			logger.error("preHandle URI:"+uri+" User:"+user+" return false");
			return false;
		}
	}
}
