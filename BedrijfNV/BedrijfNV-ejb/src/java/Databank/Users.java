/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databank;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByFunctie", query = "SELECT u FROM Users u WHERE u.functie = :functie"),
    @NamedQuery(name = "Users.findByUsernr", query = "SELECT u FROM Users u WHERE u.usernr = :usernr"),
    @NamedQuery(name = "Users.findByPaswoord", query = "SELECT u FROM Users u WHERE u.paswoord = :paswoord")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "FUNCTIE")
    private String functie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERNR")
    private BigDecimal usernr;
    @Size(max = 50)
    @Column(name = "PASWOORD")
    private String paswoord;
    @OneToMany(mappedBy = "usernr")
    private Collection<Kredieten> kredietenCollection;
    @OneToMany(mappedBy = "usernr")
    private Collection<Onkosten> onkostenCollection;
    @OneToMany(mappedBy = "baasnr")
    private Collection<Users> usersCollection;
    @JoinColumn(name = "BAASNR", referencedColumnName = "USERNR")
    @ManyToOne
    private Users baasnr;

    public Users() {
    }

    public Users(BigDecimal usernr) {
        this.usernr = usernr;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public BigDecimal getUsernr() {
        return usernr;
    }

    public void setUsernr(BigDecimal usernr) {
        this.usernr = usernr;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    @XmlTransient
    public Collection<Kredieten> getKredietenCollection() {
        return kredietenCollection;
    }

    public void setKredietenCollection(Collection<Kredieten> kredietenCollection) {
        this.kredietenCollection = kredietenCollection;
    }

    @XmlTransient
    public Collection<Onkosten> getOnkostenCollection() {
        return onkostenCollection;
    }

    public void setOnkostenCollection(Collection<Onkosten> onkostenCollection) {
        this.onkostenCollection = onkostenCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Users getBaasnr() {
        return baasnr;
    }

    public void setBaasnr(Users baasnr) {
        this.baasnr = baasnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usernr != null ? usernr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usernr == null && other.usernr != null) || (this.usernr != null && !this.usernr.equals(other.usernr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Databank.Users[ usernr=" + usernr + " ]";
    }
    
}
