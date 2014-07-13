package net.therap.service;

import net.therap.dao.StudentDao;
import net.therap.domain.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Created by shakhawat.hossain on 7/7/14.
 */

@Stateless
@TransactionManagement (value = TransactionManagementType.CONTAINER)
public class StudentService {
    @EJB
    private StudentDao studentDao;

    public void addStudent(Student student){
        studentDao.addStudent(student);
    }

    public Student getVerifiedStudent(Student student){
        Student retrievedStudent =  studentDao.getStudentByEmail(student.getEmail());

        if (retrievedStudent != null && retrievedStudent.getPassword().equals(student.getPassword())){
           return retrievedStudent;
        } else {
            return null;
        }
     }
}
