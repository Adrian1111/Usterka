/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usterka.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "Klient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klient.findAll", query = "SELECT k FROM Klient k"),
    @NamedQuery(name = "Klient.findById", query = "SELECT k FROM Klient k WHERE k.id = :id"),
    @NamedQuery(name = "Klient.findByFullName", query = "SELECT k FROM Klient k WHERE k.fullName = :fullName"),
    @NamedQuery(name = "Klient.findByEmail", query = "SELECT k FROM Klient k WHERE k.email = :email"),
    @NamedQuery(name = "Klient.findByUserPassword", query = "SELECT k FROM Klient k WHERE k.userPassword = :userPassword"),
    @NamedQuery(name = "Klient.findByInsertDateTime", query = "SELECT k FROM Klient k WHERE k.insertDateTime = :insertDateTime")})
public class Klient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "full_name")
    private String fullName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 1000)
    @Column(name = "user_password")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InsertDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<Zgloszenie> zgloszenieCollection;

    public Klient() {
    }

    public Klient(Integer id) {
        this.id = id;
    }

    public Klient(Integer id, Date insertDateTime) {
        this.id = id;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    @XmlTransient
    public Collection<Zgloszenie> getZgloszenieCollection() {
        return zgloszenieCollection;
    }

    public void setZgloszenieCollection(Collection<Zgloszenie> zgloszenieCollection) {
        this.zgloszenieCollection = zgloszenieCollection;
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
        if (!(object instanceof Klient)) {
            return false;
        }
        Klient other = (Klient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.usterka.entity.Klient[ id=" + id + " ]";
    }
    
}
