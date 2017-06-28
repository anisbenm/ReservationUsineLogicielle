/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

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
 * @author formation
 */

@Controller
public class InscriptionController {
    
    @Autowired
    UtilisateurCrudService serviceUtilisateur;
    
    @RequestMapping(value="/inscription",method = RequestMethod.GET)
    public String inscriptionGet(Model model){
        
        Utilisateur utilisateur= new Utilisateur();
        
        model.addAttribute("utilisateur",utilisateur);
        
        return"/inscription/inscription.jsp";
       
    }
    
    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String inscriptionPost(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
       
        utilisateur.setType(Utilisateur.TypeUser.CLIENT);
        //persister
        serviceUtilisateur.save(utilisateur);
        return "redirect:/identification";
    }
    
}
