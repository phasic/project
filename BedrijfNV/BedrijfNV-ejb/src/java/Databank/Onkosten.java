/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "ONKOSTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onkosten.findAll", query = "SELECT o FROM Onkosten o"),
    @NamedQuery(name = "Onkosten.findByOnkostnr", query = "SELECT o FROM Onkosten o WHERE o.onkostnr = :onkostnr"),
    @NamedQuery(name = "Onkosten.findByOmschrijving", query = "SELECT o FROM Onkosten o WHERE o.omschrijving = :omschrijving"),
    @NamedQuery(name = "Onkosten.findByDatum", query = "SELECT o FROM Onkosten o WHERE o.datum = :datum"),
    @NamedQuery(name = "Onkosten.findByBedrag", query = "SELECT o FROM Onkosten o WHERE o.bedrag = :bedrag"),
    @NamedQuery(name = "Onkosten.findByStatus", query = "SELECT o FROM Onkosten o WHERE o.status = :status")})
public class Onkosten implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ONKOSTNR")
    private BigDecimal onkostnr;
    @Size(max = 50)
    @Column(name = "OMSCHRIJVING")
    private String omschrijving;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "BEDRAG")
    private BigInteger bedrag;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "KREDIETNR", referencedColumnName = "KREDIETNR")
    @ManyToOne
    private Kredieten kredietnr;
    @JoinColumn(name = "USERNR", referencedColumnName = "USERNR")
    @ManyToOne
    private Users usernr;

    public Onkosten() {
    }

    public Onkosten(BigDecimal onkostnr) {
        this.onkostnr = onkostnr;
    }

    public BigDecimal getOnkostnr() {
        return onkostnr;
    }

    public void setOnkostnr(BigDecimal onkostnr) {
        this.onkostnr = onkostnr;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigInteger getBedrag() {
        return bedrag;
    }

    public void setBedrag(BigInteger bedrag) {
        this.bedrag = bedrag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Kredieten getKredietnr() {
        return kredietnr;
    }

    public void setKredietnr(Kredieten kredietnr) {
        this.kredietnr = kredietnr;
    }

    public Users getUsernr() {
        return usernr;
    }

    public void setUsernr(Users usernr) {
        this.usernr = usernr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (onkostnr != null ? onkostnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onkosten)) {
            return false;
        }
        Onkosten other = (Onkosten) object;
        if ((this.onkostnr == null && other.onkostnr != null) || (this.onkostnr != null && !this.onkostnr.equals(other.onkostnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Databank.Onkosten[ onkostnr=" + onkostnr + " ]";
    }
    
}
