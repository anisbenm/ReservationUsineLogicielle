/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import org.springframework.data.repository.CrudRepository;

import reservation.entity.Utilisateur;

/**
 *
 * @author Administrateur
 */
public interface UtilisateurCrudService extends CrudRepository<Utilisateur, Long>{
    //fonction magique
    public Utilisateur findOneByLoginAndMdpasse(String login,String mdp);
}
