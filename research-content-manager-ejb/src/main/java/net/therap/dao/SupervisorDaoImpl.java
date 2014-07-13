package net.therap.dao;

import net.therap.domain.Project;
import net.therap.domain.Supervisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
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
    private Logger logger = LoggerFactory.getLogger(SupervisorDaoImpl.class);

    @Override
    public Collection<Project> getProjectListBySupervisorId(int supervisorId) {
        Query query = entityManager.createQuery("FROM Supervisor supervisor LEFT JOIN FETCH supervisor.projectList WHERE supervisor.id = :id");
        query.setParameter("id", supervisorId);
        Supervisor supervisor = (Supervisor) query.getSingleResult();
        return supervisor.getProjectList();
    }

    @Override
    public Supervisor getSupervisorByEmail(String email) {
        Supervisor supervisor = null;

        TypedQuery<Supervisor> query = entityManager.createQuery("FROM Supervisor supervisor  WHERE supervisor.email = :email ", Supervisor.class);
        query.setParameter("email", email);

        try {
            supervisor = query.getSingleResult();
        }catch (NoResultException|NonUniqueResultException exp){
            logger.debug("supervisor not found "+email);
            return null;
        }
       return supervisor;
    }
}
