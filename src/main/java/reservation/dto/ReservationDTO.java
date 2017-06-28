/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import reservation.entity.Client;
import reservation.entity.Reservation;

/**
 *
 * @author Administrateur
 */
public class ReservationDTO {
     
    private Long id;
    private Date date;
    private Double prix;
    private Reservation.EtatReservation etatReservation;
    private List<Long> chambres= new ArrayList<>();
    private Client client;

    public Reservation.EtatReservation getEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(Reservation.EtatReservation etatReservation) {
        this.etatReservation = etatReservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

   
    public List<Long> getChambres() {
        return chambres;
    }

    public void setChambres(List<Long> chambres) {
        this.chambres = chambres;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
