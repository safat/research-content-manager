package net.therap.service;

import net.therap.dao.ResearchAreaDao;
import net.therap.domain.ResearchArea;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.List;

/**
 * Created by shakhawat.hossain on 7/9/14.
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class ResearchAreaService {

    @EJB
    private ResearchAreaDao researchAreaDao;

    public List<ResearchArea> getResearchAreaList(){
       return researchAreaDao.getResearchAreaList();
    }
}
