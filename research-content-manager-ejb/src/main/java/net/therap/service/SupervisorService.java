package net.therap.service;

import net.therap.dao.SupervisorDao;
import net.therap.domain.Project;
import net.therap.domain.Supervisor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/24/14
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class SupervisorService {

    @EJB
    private SupervisorDao supervisorDao;

    public Collection<Project> getProjectListBySupervisorId(int supervisorId){
      return supervisorDao.getProjectListBySupervisorId(supervisorId);
    }

    public Supervisor verifyAndGetSupervisor(Supervisor supervisor){
        return supervisorDao.getSupervisorByEmail(supervisor.getEmail());
    }
}
