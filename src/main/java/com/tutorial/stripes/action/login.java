package com.tutorial.stripes.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding( "/login" )
public class login implements ActionBean {

    private ActionBeanContext actionBeanContext;


    @Override
    public void setContext(ActionBeanContext actionBeanContext) {
        this.actionBeanContext=actionBeanContext;
    }

    @Override
    public ActionBeanContext getContext() {
        return actionBeanContext;
    }

    public Resolution login(){


        return null;
    }


}
