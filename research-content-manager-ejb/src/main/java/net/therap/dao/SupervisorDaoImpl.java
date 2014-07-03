package net.therap.dao;

import net.therap.domain.Project;
import net.therap.domain.Supervisor;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/24/14
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class SupervisorDaoImpl implements SupervisorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Project> getProjectListBySupervisorId(int supervisorId) {
        Query query = entityManager.createQuery("FROM Supervisor supervisor LEFT JOIN FETCH supervisor.projectList WHERE supervisor.id = :id");
        query.setParameter("id", supervisorId);
        Supervisor supervisor = (Supervisor) query.getSingleResult();
        return supervisor.getProjectList();
    }
}
