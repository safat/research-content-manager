package net.therap.action;

import net.therap.domain.Student;
import net.therap.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by shakhawat.hossain on 7/9/14.
 */
@ManagedBean (name = "loginAction")
@SessionScoped
public class LoginAction implements Serializable {
    private Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @EJB
    private StudentService studentService;
    private Student student;

    public String login() {
        logger.info("login request for student :" + student.getEmail());

        student = studentService.getVerifiedStudent(student);

        if (student != null) {
            return "home?faces-redirect=true";
        } else {
            return "login?faces-redirect=true";
        }
     }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @PostConstruct
    public void initBean() {
        student = new Student();
        logger.info("\n\n______________________ LoginAction Bean Constructed ____________________________\n\n");
    }

    @PreDestroy
    public void destroy() {
        logger.info("\n\n______________________ LoginAction Bean Destroyed   ____________________________\n\n");
    }


}
