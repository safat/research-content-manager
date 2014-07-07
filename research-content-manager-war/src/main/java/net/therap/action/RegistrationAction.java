package net.therap.action;

import net.therap.domain.Student;
import net.therap.service.StudentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * Created by shakhawat.hossain on 7/3/14.
 */

@ManagedBean (name = "registration", eager = true)
@ApplicationScoped
public class RegistrationAction implements Serializable {
    @EJB
    private StudentService studentService;
    private Student student;

    @PostConstruct
    public void startUp() {
       student = new Student();
    }

    public String registerStudent() {
        studentService.addStudent(student);
        return "registrationSuccess?faces-redirect=true";

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
