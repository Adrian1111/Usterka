/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usterka.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "Kategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategoria.findAll", query = "SELECT k FROM Kategoria k"),
    @NamedQuery(name = "Kategoria.findById", query = "SELECT k FROM Kategoria k WHERE k.id = :id"),
    @NamedQuery(name = "Kategoria.findByName", query = "SELECT k FROM Kategoria k WHERE k.name = :name")})
public class Kategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Rodzajusterki> rodzajusterkiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentCategoryId")
    private Collection<Kategoria> kategoriaCollection;
    @JoinColumn(name = "parent_category_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Kategoria parentCategoryId;

    public Kategoria() {
    }

    public Kategoria(Integer id) {
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

    @XmlTransient
    public Collection<Rodzajusterki> getRodzajusterkiCollection() {
        return rodzajusterkiCollection;
    }

    public void setRodzajusterkiCollection(Collection<Rodzajusterki> rodzajusterkiCollection) {
        this.rodzajusterkiCollection = rodzajusterkiCollection;
    }

    @XmlTransient
    public Collection<Kategoria> getKategoriaCollection() {
        return kategoriaCollection;
    }

    public void setKategoriaCollection(Collection<Kategoria> kategoriaCollection) {
        this.kategoriaCollection = kategoriaCollection;
    }

    public Kategoria getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Kategoria parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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
        if (!(object instanceof Kategoria)) {
            return false;
        }
        Kategoria other = (Kategoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.usterka.entity.Kategoria[ id=" + id + " ]";
    }
    
}
