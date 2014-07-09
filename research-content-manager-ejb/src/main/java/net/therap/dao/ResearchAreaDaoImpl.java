package net.therap.dao;

import net.therap.domain.ResearchArea;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by shakhawat.hossain on 7/9/14.
 */

@Stateless
public class ResearchAreaDaoImpl implements ResearchAreaDao {
   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public List<ResearchArea> getResearchAreaList() {
        Query query = entityManager.createQuery("FROM ResearchArea researchArea", ResearchArea.class);
        return query.getResultList();
    }
}
