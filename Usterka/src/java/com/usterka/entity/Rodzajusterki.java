/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usterka.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "Rodzaj_usterki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rodzajusterki.findAll", query = "SELECT r FROM Rodzajusterki r"),
    @NamedQuery(name = "Rodzajusterki.findById", query = "SELECT r FROM Rodzajusterki r WHERE r.id = :id"),
    @NamedQuery(name = "Rodzajusterki.findByName", query = "SELECT r FROM Rodzajusterki r WHERE r.name = :name"),
    @NamedQuery(name = "Rodzajusterki.findByDescriptionOf", query = "SELECT r FROM Rodzajusterki r WHERE r.descriptionOf = :descriptionOf")})
public class Rodzajusterki implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 1000)
    @Column(name = "descriptionOf")
    private String descriptionOf;
    @JoinColumn(name = "category_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Kategoria categoryId;
    @JoinColumn(name = "defect_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Zgloszenie defectId;

    public Rodzajusterki() {
    }

    public Rodzajusterki(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionOf() {
        return descriptionOf;
    }

    public void setDescriptionOf(String descriptionOf) {
        this.descriptionOf = descriptionOf;
    }

    public Kategoria getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Kategoria categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Rodzajusterki)) {
            return false;
        }
        Rodzajusterki other = (Rodzajusterki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.usterka.entity.Rodzajusterki[ id=" + id + " ]";
    }
    
}
