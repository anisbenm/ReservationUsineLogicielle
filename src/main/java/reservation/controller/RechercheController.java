/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import reservation.dto.RechercheDTO;
import reservation.entity.Chambre;
import reservation.service.RechercheService;

/**
 *
 * @author Administrateur
 */
@Controller
public class RechercheController {
    
    @Autowired
    private RechercheService recService;
    
    @RequestMapping(value = "/recherche", method = RequestMethod.GET)
    public String rechercherGet(Model model){
        RechercheDTO rec=new RechercheDTO();
        model.addAttribute("rec", rec);
    return "/rechercher/recherche.jsp";
    }
    
   @RequestMapping(value = "/recherche", method = RequestMethod.POST)
    public String rechercherPost(Model model, @ModelAttribute("rec") RechercheDTO dto){
       List<Chambre> listChambre= recService.rechercher(dto.getLocalite(), dto.getNbp(), dto.getDebut(), dto.getFin());
        model.addAttribute("chambres", listChambre);
    return "/rechercher/lister.jsp";
    }
}
