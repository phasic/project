package Databank;

import Databank.Kredieten;
import Databank.Users;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-06T12:54:53")
@StaticMetamodel(Onkosten.class)
public class Onkosten_ { 

    public static volatile SingularAttribute<Onkosten, BigDecimal> onkostnr;
    public static volatile SingularAttribute<Onkosten, String> omschrijving;
    public static volatile SingularAttribute<Onkosten, Date> datum;
    public static volatile SingularAttribute<Onkosten, Users> usernr;
    public static volatile SingularAttribute<Onkosten, Kredieten> kredietnr;
    public static volatile SingularAttribute<Onkosten, BigInteger> bedrag;
    public static volatile SingularAttribute<Onkosten, String> status;

}