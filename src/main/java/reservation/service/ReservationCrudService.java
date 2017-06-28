/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.Date;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Client;
import reservation.entity.Reservation;

/**
 *
 * @author Administrateur
 */
public interface ReservationCrudService extends CrudRepository<Reservation, Long>{
    
    public long countByChambresIdAndDateCheckInBetween(long idch,Date debut,Date fin);
    public long countByChambresIdAndDateCheckOutBetween(long idch,Date debut,Date fin);
}
