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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Hotel;
import reservation.service.HotelCrudService;

/**
 *
 * @author anis
 */
@Controller
@RequestMapping(value = "/hotel")
public class HotelController {
    @Autowired
    private HotelCrudService service;
    
    @RequestMapping(value = "/ajouter")
    public String ajouterGet(Model model) {
        Hotel h = new Hotel();
        // passer cet hotel à la vue
        model.addAttribute("hotel", h);
        return "/hotel/ajouter.jsp";
    }



    @RequestMapping(value = "/ajoutExe", method = RequestMethod.POST)//par defaut get
    public String ajouter(@ModelAttribute("hotel") Hotel h) {
        //persister
        service.save(h);
        return "redirect:/hotel/lister";
    }

    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifier(@ModelAttribute("hotel") Hotel h) {
        //persister
        service.save(h);
        return "redirect:/hotel/lister";
    }

    @RequestMapping(value = "/modifier/{id}")
    public String afficheModif(@PathVariable("id") long id, Model model) {
        //recuperer l'hotel à modifier
        Hotel h = service.findOne(id);

        // passer cet hotel à la vue
        model.addAttribute("hotel", h);
        return "/hotel/modifier.jsp";
    }

    @RequestMapping(value = "/lister")
    public String lister(Model model) {
        List<Hotel> hotels = (List<Hotel>) service.findAll();
        model.addAttribute("hotels", hotels);
        return "/hotel/lister.jsp";
    }

    @RequestMapping(value = "/supprimer/{hotelId}")
    public String supprimer(@PathVariable("hotelId") long id) {
        service.delete(id);
        return "redirect:/hotel/lister";//envoi une repense au client pour qu il emmet une requete get
    }

}
