/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usterka.entity;

import java.io.Serializable;
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
 * @author Adrian
 */
@Entity
@Table(name = "Status_zgloszenia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statuszgloszenia.findAll", query = "SELECT s FROM Statuszgloszenia s"),
    @NamedQuery(name = "Statuszgloszenia.findById", query = "SELECT s FROM Statuszgloszenia s WHERE s.id = :id"),
    @NamedQuery(name = "Statuszgloszenia.findByStatusOfCall", query = "SELECT s FROM Statuszgloszenia s WHERE s.statusOfCall = :statusOfCall"),
    @NamedQuery(name = "Statuszgloszenia.findByDateOfFix", query = "SELECT s FROM Statuszgloszenia s WHERE s.dateOfFix = :dateOfFix")})
public class Statuszgloszenia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "statusOfCall")
    private String statusOfCall;
    @Column(name = "dateOfFix")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfFix;
    @JoinColumn(name = "defect_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Zgloszenie defectId;

    public Statuszgloszenia() {
    }

    public Statuszgloszenia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusOfCall() {
        return statusOfCall;
    }

    public void setStatusOfCall(String statusOfCall) {
        this.statusOfCall = statusOfCall;
    }

    public Date getDateOfFix() {
        return dateOfFix;
    }

    public void setDateOfFix(Date dateOfFix) {
        this.dateOfFix = dateOfFix;
    }

    public Zgloszenie getDefectId() {
        return defectId;
    }

    public void setDefectId(Zgloszenie defectId) {
        this.defectId = defectId;
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
        if (!(object instanceof Statuszgloszenia)) {
            return false;
        }
        Statuszgloszenia other = (Statuszgloszenia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.usterka.entity.Statuszgloszenia[ id=" + id + " ]";
    }
    
}
