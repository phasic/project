package Databank;

import Databank.Onkosten;
import Databank.Users;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-06T12:54:53")
@StaticMetamodel(Kredieten.class)
public class Kredieten_ { 

    public static volatile SingularAttribute<Kredieten, Users> usernr;
    public static volatile SingularAttribute<Kredieten, BigDecimal> kredietnr;
    public static volatile CollectionAttribute<Kredieten, Onkosten> onkostenCollection;
    public static volatile SingularAttribute<Kredieten, BigInteger> saldo;
    public static volatile SingularAttribute<Kredieten, String> soort;

}