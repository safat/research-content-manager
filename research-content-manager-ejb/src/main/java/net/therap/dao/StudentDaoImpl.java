package net.therap.dao;

import net.therap.domain.Student;
import net.therap.domain.Supervisor;
import net.therap.domain.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/22/14
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUserList(){
        return entityManager.createQuery("SELECT supervisor FROM Supervisor supervisor").getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(Supervisor.class, id);
    }

    @Override
    public boolean isEmailAlreadyRegistered(String email) {
        Query query = entityManager.createQuery("FROM Student student WHERE student.email = :email", Student.class);
        query.setParameter("email", email);
        List<Student> studentList = query.getResultList();
        return !studentList.isEmpty();
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
        entityManager.flush();
    }
}
