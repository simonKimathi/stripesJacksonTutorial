package com.tutorial.stripes.DAO;

import com.tutorial.stripes.EJB.loginBeanI;
import com.tutorial.stripes.model.User;

import javax.ejb.EJB;
import javax.inject.Inject;

public class loginDao {

    @EJB
    private loginBeanI loginBean;

    @Inject
    private User user;
}
