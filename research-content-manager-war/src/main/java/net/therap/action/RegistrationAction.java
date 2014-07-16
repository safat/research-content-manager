package net.therap.action;

import net.therap.domain.Student;
import net.therap.service.EmailConfirmationQueueProducer;
import net.therap.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by shakhawat.hossain on 7/3/14.
 */

@ManagedBean (name = "registration")
@ViewScoped
public class RegistrationAction implements Serializable {
    private Logger logger = LoggerFactory.getLogger(RegistrationAction.class);

    @EJB
    private StudentService studentService;
    @EJB
    private EmailConfirmationQueueProducer emailConfirmationQueue;

    private Student student;

    @PostConstruct
    public void initBean() {
        logger.info("\n\n______________________RegistrationAction Bean Constructed____________________________\n\n");
        student = new Student();
    }

    public String registerStudent() {
        logger.info("Registration request from " + student.getEmail());
        emailConfirmationQueue.queueEmailConfirmation(student.getEmail());
//        studentService.addStudent(student);
        return "registrationSuccess?faces-redirect=true";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @PreDestroy
    public void destroy() {
        logger.info("\n\n_____________________RegistrationAction Bean destroyed____________________________\n\n");
    }
}
