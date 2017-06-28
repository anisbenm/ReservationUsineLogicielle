package reservation.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import reservation.entity.Reservation.EtatReservation;

@Generated(value="Dali", date="2017-06-28T11:33:35.493+0200")
@StaticMetamodel(Reservation.class)
public class Reservation_ {
	public static volatile SingularAttribute<Reservation, Long> id;
	public static volatile SingularAttribute<Reservation, Date> date;
	public static volatile SingularAttribute<Reservation, Double> prix;
	public static volatile SingularAttribute<Reservation, EtatReservation> etatReservation;
	public static volatile SingularAttribute<Reservation, Date> dateCheckIn;
	public static volatile SingularAttribute<Reservation, Date> dateCheckOut;
	public static volatile ListAttribute<Reservation, Chambre> chambres;
	public static volatile SingularAttribute<Reservation, Client> client;
}
