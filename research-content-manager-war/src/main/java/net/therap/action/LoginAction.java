package net.therap.action;

import net.therap.domain.Supervisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * Created by shakhawat.hossain on 7/9/14.
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginAction implements Serializable {
    private Logger logger = LoggerFactory.getLogger(LoginAction.class);
    private Supervisor supervisor;

    @PostConstruct
    public void initBean(){
        supervisor = new Supervisor();
        logger.info("\n\n______________________ LoginAction Bean Constructed ____________________________\n\n") ;
    }

    public void destroy(){
        logger.info("\n\n______________________ LoginAction Bean Destroyed   ____________________________\n\n") ;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }


}
