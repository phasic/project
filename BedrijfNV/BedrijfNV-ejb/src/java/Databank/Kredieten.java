/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "KREDIETEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kredieten.findAll", query = "SELECT k FROM Kredieten k"),
    @NamedQuery(name = "Kredieten.findByKredietnr", query = "SELECT k FROM Kredieten k WHERE k.kredietnr = :kredietnr"),
    @NamedQuery(name = "Kredieten.findBySaldo", query = "SELECT k FROM Kredieten k WHERE k.saldo = :saldo"),
    @NamedQuery(name = "Kredieten.findBySoort", query = "SELECT k FROM Kredieten k WHERE k.soort = :soort")})
public class Kredieten implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KREDIETNR")
    private BigDecimal kredietnr;
    @Column(name = "SALDO")
    private BigInteger saldo;
    @Size(max = 50)
    @Column(name = "SOORT")
    private String soort;
    @JoinColumn(name = "USERNR", referencedColumnName = "USERNR")
    @ManyToOne
    private Users usernr;
    @OneToMany(mappedBy = "kredietnr")
    private Collection<Onkosten> onkostenCollection;

    public Kredieten() {
    }

    public Kredieten(BigDecimal kredietnr) {
        this.kredietnr = kredietnr;
    }

    public BigDecimal getKredietnr() {
        return kredietnr;
    }

    public void setKredietnr(BigDecimal kredietnr) {
        this.kredietnr = kredietnr;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public Users getUsernr() {
        return usernr;
    }

    public void setUsernr(Users usernr) {
        this.usernr = usernr;
    }

    @XmlTransient
    public Collection<Onkosten> getOnkostenCollection() {
        return onkostenCollection;
    }

    public void setOnkostenCollection(Collection<Onkosten> onkostenCollection) {
        this.onkostenCollection = onkostenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kredietnr != null ? kredietnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kredieten)) {
            return false;
        }
        Kredieten other = (Kredieten) object;
        if ((this.kredietnr == null && other.kredietnr != null) || (this.kredietnr != null && !this.kredietnr.equals(other.kredietnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Databank.Kredieten[ kredietnr=" + kredietnr + " ]";
    }
    
}
