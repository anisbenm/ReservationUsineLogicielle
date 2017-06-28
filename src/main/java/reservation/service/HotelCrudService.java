/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Hotel;

/**
 *
 * @author Administrateur
 */
public interface HotelCrudService extends CrudRepository<Hotel, Long>{
    //pas besoin
//    @Query("SELECT h FROM Hotel h where h.adresse.localite=?1")
//    public List<Hotel> listHotelParLocalite(String l);
}
