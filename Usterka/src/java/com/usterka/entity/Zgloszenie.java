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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Zgloszenie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zgloszenie.findAll", query = "SELECT z FROM Zgloszenie z"),
    @NamedQuery(name = "Zgloszenie.findById", query = "SELECT z FROM Zgloszenie z WHERE z.id = :id"),
    @NamedQuery(name = "Zgloszenie.findByDefectNo", query = "SELECT z FROM Zgloszenie z WHERE z.defectNo = :defectNo"),
    @NamedQuery(name = "Zgloszenie.findByInsertDateTime", query = "SELECT z FROM Zgloszenie z WHERE z.insertDateTime = :insertDateTime")})
public class Zgloszenie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "defect_no")
    private String defectNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InsertDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "defectId")
    private Collection<Rodzajusterki> rodzajusterkiCollection;
    @JoinColumn(name = "client_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Klient clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "defectId")
    private Collection<Statuszgloszenia> statuszgloszeniaCollection;

    public Zgloszenie() {
    }

    public Zgloszenie(Integer id) {
        this.id = id;
    }

    public Zgloszenie(Integer id, Date insertDateTime) {
        this.id = id;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDefectNo() {
        return defectNo;
    }

    public void setDefectNo(String defectNo) {
        this.defectNo = defectNo;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    @XmlTransient
    public Collection<Rodzajusterki> getRodzajusterkiCollection() {
        return rodzajusterkiCollection;
    }

    public void setRodzajusterkiCollection(Collection<Rodzajusterki> rodzajusterkiCollection) {
        this.rodzajusterkiCollection = rodzajusterkiCollection;
    }

    public Klient getClientId() {
        return clientId;
    }

    public void setClientId(Klient clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public Collection<Statuszgloszenia> getStatuszgloszeniaCollection() {
        return statuszgloszeniaCollection;
    }

    public void setStatuszgloszeniaCollection(Collection<Statuszgloszenia> statuszgloszeniaCollection) {
        this.statuszgloszeniaCollection = statuszgloszeniaCollection;
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
        if (!(object instanceof Zgloszenie)) {
            return false;
        }
        Zgloszenie other = (Zgloszenie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.usterka.entity.Zgloszenie[ id=" + id + " ]";
    }
    
}
