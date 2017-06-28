package reservation.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-28T11:33:35.462+0200")
@StaticMetamodel(Adresse.class)
public class Adresse_ {
	public static volatile SingularAttribute<Adresse, Short> num;
	public static volatile SingularAttribute<Adresse, String> rue;
	public static volatile SingularAttribute<Adresse, String> localite;
	public static volatile SingularAttribute<Adresse, Long> codepostal;
	public static volatile SingularAttribute<Adresse, String> pays;
}
