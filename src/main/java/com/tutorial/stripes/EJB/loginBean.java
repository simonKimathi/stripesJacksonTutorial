package com.tutorial.stripes.EJB;

import com.tutorial.stripes.action.AbstractBeanImpl;
import com.tutorial.stripes.commons.Constants;
import com.tutorial.stripes.model.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class loginBean extends AbstractBeanImpl<User, Long> {

    @PersistenceContext(name = Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    public loginBean() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
