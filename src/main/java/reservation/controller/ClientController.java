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
import reservation.entity.Client;
import reservation.service.ClientCrudService;
import reservation.service.ReservationCrudService;

/**
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientCrudService clService;
    @Autowired
    ReservationCrudService resService;

    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifierExe(@ModelAttribute("client") Client c) {
        clService.save(c);

        return "redirect:/client/lister";
    }

    @RequestMapping(value = "/modifier/{clId}", method = RequestMethod.GET)
    public String modifier(Model model, @PathVariable("clId") long id) {
        model.addAttribute("client", clService.findOne(id));

        return "/client/modifier.jsp";
    }

    @RequestMapping(value = "/supprimer/{clId}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("clId") long id) {
        clService.delete(id);
        return "redirect:/client/lister";
    }

    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("clients", clService.findAll());

        return "/client/lister.jsp";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouter(Model model) {
        model.addAttribute("client", new Client());
        return "/client/ajouter.jsp";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterExe(@ModelAttribute("client") Client c) {
        clService.save(c);
        return "redirect:/client/lister";
    }
}
