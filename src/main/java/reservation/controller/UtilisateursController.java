/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Utilisateur;
import reservation.service.UtilisateurCrudService;

/**
 *
 * @author Administrateur
 */
@Controller
public class UtilisateursController {

    @Autowired
    UtilisateurCrudService service;

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnexion(HttpSession session) {
        session.invalidate();
        return "redirect:/identification";
    }

    @RequestMapping(value = "/identification", method = RequestMethod.GET)
    public String identificationGET(Model model) {
        model.addAttribute("util", new Utilisateur());
        return "/identification.jsp";
    }

    @RequestMapping(value = "/identification", method = RequestMethod.POST)
    public String identificationPost(@ModelAttribute("util") Utilisateur u, HttpSession session) {
        //revoie vers la page d'identification si pas admin/admin
        Utilisateur user = service.findOneByLoginAndMdpasse(u.getLogin(), u.getMdpasse());

        if (user == null) {
            return "redirect:/home";
        }
        // enregistrer en session que l'util est admin
        session.setAttribute("userType", user.getType().toString());
        session.setAttribute("Utilisateur", user);
        // on choisi de rediriger vers la liste des hotels
        return "redirect:/reservationClient";
    }
}
