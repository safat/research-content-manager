package net.therap.action;

import net.therap.domain.Student;
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
    @EJB
    private StudentService studentService;
    private Student student;

    private Logger logger = LoggerFactory.getLogger(RegistrationAction.class);

    @PostConstruct
    public void initBean() {
       logger.info("\n\n______________________RegistrationAction Bean Constructed____________________________\n\n") ;
       student = new Student();
    }

    public String registerStudent() {
        logger.info("Registration request from "+student.getEmail());
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
    public void destroy(){
        logger.info("\n\n_____________________RegistrationAction Bean destroyed____________________________\n\n");
    }
}
