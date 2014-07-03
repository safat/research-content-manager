package net.therap.dao;

import net.therap.domain.Supervisor;
import net.therap.domain.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class UserDaoImpl implements UserDao{

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
}
