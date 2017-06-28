/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.entity.Chambre;

/**
 *
 * @author Administrateur
 */
@Service////////////////////////////////non crud pour autowired
public class RechercheService {
    
    @Autowired
    ChambreCrudService chserv;
    
    @Autowired 
    ReservationCrudService resServ;
    
    public List<Chambre> rechercher(String localite, int nbp, Date debut, Date fin){
        List<Chambre> li=chserv.findAllByHotelAdresseLocaliteAndNbPersonnesGreaterThanEqualOrderByHotel(localite, nbp);
        for(Chambre c:li){
            if(resServ.countByChambresIdAndDateCheckInBetween(nbp, debut, fin)+resServ.countByChambresIdAndDateCheckOutBetween(nbp, debut, fin)>0){
                li.remove(c);
            }
        }
        return li;
    }
    //rechercher chambres dont l'hotel est dans la localite priécisée et ayant une capacité>à la capacité voulu
    // itération sur chaque chambre
    
    //chambres libres
    //compter le nombre de reservation de cette chambre dont la date de check in reservation est plus grand que le checkout voulu ou le checkout reservation plus petit que le check in voulu
    // (a OR b)/ == a/ AND b/ 
    // compter le nb de res dont la date de checkin <= date checkout voulu et la date de check >= date checkin voulu
    //si nb>0 on elimine la chambre
}
