/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Chambre;

/**
 *
 * @author Administrateur
 */
public interface ChambreCrudService extends CrudRepository<Chambre, Long>{
    //rechercher chambres dont l'hotel est dans la localite priécisée et ayant une capacité>à la capacité voulu
//    public List<Chambre> findAllBy
    
    
    //toutes les chambre de la loclité dont le nb personnes est convenable
    public List<Chambre> findAllByHotelAdresseLocaliteAndNbPersonnesGreaterThanEqualOrderByHotel(String l,int nbp);
    
   
    
 }
