package reservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import reservation.entity.Utilisateur;

@Controller
@RequestMapping(value="**/**")
public class MainController {

	private static Logger log = Logger.getLogger(MainController.class);
	
	@RequestMapping(value = { "/", "/**" }, method = RequestMethod.GET)
	public String checkForAll(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		log.info("Check for All :"+uri);
		Utilisateur user = (Utilisateur) session.getAttribute("Utilisateur");
		if ( user != null && user.getId() > 0 ){
			log.info("User :"+user.getLogin()+" OK, uri:"+uri);
			return "forward:"+uri;
		}else{
			return "/home.jsp";
		}
	}
}
