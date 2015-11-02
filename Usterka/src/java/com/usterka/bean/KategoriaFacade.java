/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usterka.bean;

import com.usterka.entity.Kategoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class KategoriaFacade extends AbstractFacade<Kategoria> {
    @PersistenceContext(unitName = "UsterkaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KategoriaFacade() {
        super(Kategoria.class);
    }
    
}
