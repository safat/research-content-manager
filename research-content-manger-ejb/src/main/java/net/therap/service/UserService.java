package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/22/14
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserService {
    @EJB
    UserDao userDao;

    public List<User> getUserList() {
        return userDao.getUserList();
    }

    public boolean isValidUser(User user) {
        boolean isValidUser = false;
        User retrievedUser = userDao.getUserById(user.getId());
        if (retrievedUser != null && user.getPassword().equals(retrievedUser.getPassword())) {
            isValidUser = true;
        }
        return isValidUser;
    }
}
