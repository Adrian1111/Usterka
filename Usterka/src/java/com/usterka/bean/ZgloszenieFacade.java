/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usterka.bean;

import com.usterka.entity.Zgloszenie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class ZgloszenieFacade extends AbstractFacade<Zgloszenie> {
    @PersistenceContext(unitName = "UsterkaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZgloszenieFacade() {
        super(Zgloszenie.class);
    }
    
}
