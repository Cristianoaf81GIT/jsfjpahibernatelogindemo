package com.profcristianoaf81.jpajsflogindemo1.menagedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cristianoaf81
 */
@ManagedBean(name="logoutMB")
@SessionScoped
public class LogOutManagedBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public String logOut(){
        FacesContext cntx = FacesContext.getCurrentInstance();        
        cntx.getExternalContext().invalidateSession();
        // return /
        return"/index";
    }

}
