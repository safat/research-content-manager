package net.therap.service;

import net.therap.dao.StudentDao;
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
    StudentDao studentDao;

    public List<User> getUserList() {
        return studentDao.getUserList();
    }

    public boolean isValidUser(User user) {
        boolean isValidUser = false;
        User retrievedUser = studentDao.getUserById(user.getId());
        if (retrievedUser != null && user.getPassword().equals(retrievedUser.getPassword())) {
            isValidUser = true;
        }
        return isValidUser;
    }

   public boolean isEmailAlreadyRegistered(String email){
      return studentDao.isEmailAlreadyRegistered(email);
   }

}
