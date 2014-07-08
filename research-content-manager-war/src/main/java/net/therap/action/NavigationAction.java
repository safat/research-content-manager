package net.therap.action;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * Created by shakhawat.hossain on 7/1/14.
 */
@ManagedBean (name = "navigationAction", eager = true)
@RequestScoped
public class NavigationAction implements Serializable {

    public String showPage(String page) {
        return page+"?faces-redirect=true";
    }
}
