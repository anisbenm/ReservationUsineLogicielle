package reservation.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-28T11:33:35.477+0200")
@StaticMetamodel(Hotel.class)
public class Hotel_ {
	public static volatile SingularAttribute<Hotel, Long> id;
	public static volatile SingularAttribute<Hotel, String> nom;
	public static volatile SingularAttribute<Hotel, Adresse> adresse;
	public static volatile ListAttribute<Hotel, Chambre> chambres;
}
