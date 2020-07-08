/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.session;

import com.example.entity.Accounts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vuduy
 */
@Stateless
public class AccountsFacade extends AbstractFacade<Accounts> implements AccountsFacadeLocal {

    @PersistenceContext(unitName = "ejb01-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountsFacade() {
        super(Accounts.class);
    }

    @Override
    public Boolean checkLogin(String username, String password) {
        Query query = em.createNamedQuery("Accounts.checkLogin");
        query.setParameter("username", username);
        query.setParameter("password", password);
        Accounts accounts = (Accounts)query.getSingleResult();
        return accounts!=null;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
