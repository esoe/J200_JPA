package ru.molokoin.j200_jpa.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "DOMAINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domains.findAll", query = "SELECT d FROM Domains d")
    , @NamedQuery(name = "Domains.findById", query = "SELECT d FROM Domains d WHERE d.id = :id")
    , @NamedQuery(name = "Domains.findByWebname", query = "SELECT d FROM Domains d WHERE d.webname = :webname")
    , @NamedQuery(name = "Domains.findByDomainname", query = "SELECT d FROM Domains d WHERE d.domainname = :domainname")
    , @NamedQuery(name = "Domains.findByIp", query = "SELECT d FROM Domains d WHERE d.ip = :ip")
    , @NamedQuery(name = "Domains.findByDatereg", query = "SELECT d FROM Domains d WHERE d.datereg = :datereg")
    , @NamedQuery(name = "Domains.findByCountryreg", query = "SELECT d FROM Domains d WHERE d.countryreg = :countryreg")})
public class Domains implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "WEBNAME", length = 100)
    private String webname;
    @Column(name = "DOMAINNAME", length = 50)
    private String domainname;
    @Column(name = "IP", length = 500)
    private String ip;
    @Column(name = "DATEREG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datereg;
    @Column(name = "COUNTRYREG", length = 500)
    private String countryreg;
    @JoinColumn(name = "PERSONID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person personid;

    public Domains() {
    }

    public Domains(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDatereg() {
        return datereg;
    }

    public void setDatereg(Date datereg) {
        this.datereg = datereg;
    }

    public String getCountryreg() {
        return countryreg;
    }

    public void setCountryreg(String countryreg) {
        this.countryreg = countryreg;
    }

    public Person getPersonid() {
        return personid;
    }

    public void setPersonid(Person personid) {
        this.personid = personid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domains)) {
            return false;
        }
        Domains other = (Domains) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domains{" + "id=" + id + ", webname=" + webname + ", domainname=" + domainname + ", ip=" + ip + ", datereg=" + datereg + ", countryreg=" + countryreg + '}';
    }

    
    
}
