package reservation.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-28T11:33:35.477+0200")
@StaticMetamodel(Client.class)
public class Client_ {
	public static volatile SingularAttribute<Client, Long> id;
	public static volatile SingularAttribute<Client, Utilisateur> util;
	public static volatile SingularAttribute<Client, String> nom;
	public static volatile SingularAttribute<Client, String> prenom;
	public static volatile ListAttribute<Client, Reservation> reservations;
}
