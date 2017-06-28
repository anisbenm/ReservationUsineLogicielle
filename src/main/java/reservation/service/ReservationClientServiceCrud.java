/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Reservation;

/**
 *
 * @author formation
 */
public interface ReservationClientServiceCrud extends CrudRepository<Reservation, Long>{
    
    
   
    
  
    @Query("SELECT r FROM Reservation r JOIN r.client c WHERE c.id=?1 AND r.etatReservation=?2 ORDER BY r.date ")
    public List<Reservation> reservationClient(long idClient, Reservation.EtatReservation etat); 
      
      
    
}
    

