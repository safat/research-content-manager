package net.therap.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created by shakhawat.hossain on 7/10/14.
 */


@ManagedBean (name = "logoutAction")
@RequestScoped
public class LogoutAction {

    public String logout(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();
        return "login?faces-redirect=true";
    }
}
