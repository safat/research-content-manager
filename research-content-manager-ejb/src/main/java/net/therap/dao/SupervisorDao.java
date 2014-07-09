package net.therap.dao;

import net.therap.domain.Project;
import net.therap.domain.Supervisor;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/24/14
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface SupervisorDao {
    public Collection<Project> getProjectListBySupervisorId(int supervisorId);
    public Supervisor getSupervisorByEmail(String email);
}
