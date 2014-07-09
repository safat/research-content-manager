package net.therap.action;

import net.therap.domain.Supervisor;
import net.therap.service.SupervisorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * Created by shakhawat.hossain on 7/9/14.
 */
@ManagedBean (name = "login")
@SessionScoped
public class LoginAction implements Serializable {
    private Logger logger = LoggerFactory.getLogger(LoginAction.class);
    private Supervisor supervisor;

    @EJB
    private SupervisorService supervisorService;


    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public String login() {
        Supervisor verifiedSupervisor = supervisorService.verifyAndGetSupervisor(supervisor);
        if (verifiedSupervisor != null) {
            return "home?faces-redirect=true";
        } else {
            return "login?faces-redirect=true";
        }

    }


    @PostConstruct
    public void initBean() {
        supervisor = new Supervisor();
        logger.info("\n\n______________________ LoginAction Bean Constructed ____________________________\n\n");
    }

    public void destroy() {
        logger.info("\n\n______________________ LoginAction Bean Destroyed   ____________________________\n\n");
    }


}
