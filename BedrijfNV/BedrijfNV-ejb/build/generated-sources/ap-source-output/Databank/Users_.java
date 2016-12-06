package Databank;

import Databank.Kredieten;
import Databank.Onkosten;
import Databank.Users;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-06T12:54:53")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> functie;
    public static volatile SingularAttribute<Users, BigDecimal> usernr;
    public static volatile CollectionAttribute<Users, Kredieten> kredietenCollection;
    public static volatile CollectionAttribute<Users, Onkosten> onkostenCollection;
    public static volatile SingularAttribute<Users, String> paswoord;
    public static volatile SingularAttribute<Users, Users> baasnr;
    public static volatile CollectionAttribute<Users, Users> usersCollection;

}