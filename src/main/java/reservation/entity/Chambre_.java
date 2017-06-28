package reservation.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-28T11:33:35.462+0200")
@StaticMetamodel(Chambre.class)
public class Chambre_ {
	public static volatile SingularAttribute<Chambre, Long> id;
	public static volatile SingularAttribute<Chambre, String> nom;
	public static volatile SingularAttribute<Chambre, Double> prix;
	public static volatile SingularAttribute<Chambre, Integer> nbPersonnes;
	public static volatile SingularAttribute<Chambre, Hotel> hotel;
	public static volatile ListAttribute<Chambre, Reservation> reservations;
}
