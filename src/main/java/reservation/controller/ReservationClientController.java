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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import reservation.entity.Reservation;
import reservation.service.ReservationClientServiceCrud;

/**
 *
 * @author formation
 */

@Controller
public class ReservationClientController {
    
     @Autowired
     ReservationClientServiceCrud serviceReservationClient;
    
    @RequestMapping(value = "/reservationClient", method = RequestMethod.GET)
    public String ReservationClientGet(Model model){ 
       
        long id_client =1;
        
        Reservation.EtatReservation etat=Reservation.EtatReservation.PAYEE ;
        Reservation.EtatReservation etat2=Reservation.EtatReservation.ANNULEE;
        Reservation.EtatReservation etat3=Reservation.EtatReservation.A_PAYER;
        //une nouvelle reservation 
        List <Reservation> reservationsPayee = (List <Reservation>)  serviceReservationClient.reservationClient(id_client, etat);
        List <Reservation> reservationsAnnulee = (List <Reservation>)  serviceReservationClient.reservationClient(id_client, etat2);
        List <Reservation> reservationsAPayee = (List <Reservation>)  serviceReservationClient.reservationClient(id_client, etat3);
        model.addAttribute("reservationsPayee",  reservationsPayee);
        model.addAttribute("reservationsAnnulee",  reservationsAnnulee);
        model.addAttribute("reservationsAPayee",  reservationsAPayee);
         
        return "/reservationclient/liste.jsp"; 
       
        
    }
    
    @RequestMapping(value = "/reservationClient/details", method = RequestMethod.GET) 
    public String details ( Model model , @PathVariable("id") Long id){
      
        Reservation reservation = serviceReservationClient.findOne(id);

        // passer la reservation à la vue
        model.addAttribute("reservation", reservation);
        return "/reservationclient/details.jsp";
      
     
    
  }

}