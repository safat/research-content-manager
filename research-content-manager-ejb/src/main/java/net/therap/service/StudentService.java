package net.therap.service;

import net.therap.dao.StudentDao;
import net.therap.domain.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by shakhawat.hossain on 7/7/14.
 */

@Stateless
public class StudentService {
    @EJB
    private StudentDao studentDao;

    public void addStudent(Student student){
        studentDao.addStudent(student);
    }
}
