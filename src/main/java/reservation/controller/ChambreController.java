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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.service.ChambreCrudService;
import reservation.service.HotelCrudService;

/**
 *
 * @author anis
 */
@Controller
@RequestMapping(value = "/chambre")
public class ChambreController {

    @Autowired
    ChambreCrudService chService;
    
    @Autowired
    HotelCrudService hoService;
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifierPost(@ModelAttribute("chambre") Chambre c) {
        chService.save(c);
        return "redirect:/chambre/lister";
    }
    
    @RequestMapping(value = "/modifier/{chId}", method = RequestMethod.GET)
    public String modifierGet(@PathVariable("chId") long id, Model model) {

        model.addAttribute("chambre", chService.findOne(id));
        model.addAttribute("hotels", hoService.findAll());
        return "/chambre/modifier.jsp";
    }

    @RequestMapping(value = "/supprimer/{idCh}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("idCh") long id) {
        chService.delete(id);
        return "redirect:/chambre/lister";
    }

    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("chambres", chService.findAll());
        return "/chambre/lister.jsp";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouterGet(Model model) {

        model.addAttribute("chambre", new Chambre());
        model.addAttribute("hotels", hoService.findAll());
        return "/chambre/ajouter.jsp";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouter(@ModelAttribute Chambre c) {
        chService.save(c);
        return "redirect:/chambre/lister";
    }
}
