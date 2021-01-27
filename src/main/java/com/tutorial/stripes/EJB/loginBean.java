package com.tutorial.stripes.EJB;

import com.tutorial.stripes.commons.Constants;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class loginBean {

    @PersistenceContext(name = Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager em;



}
