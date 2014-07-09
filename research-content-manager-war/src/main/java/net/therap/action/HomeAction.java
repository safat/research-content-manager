package net.therap.action;

import net.therap.domain.ResearchArea;
import net.therap.service.ResearchAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

/**
 * Created by shakhawat.hossain on 7/1/14.
 */

@ManagedBean (name = "homeAction", eager = true)
@ApplicationScoped
public class HomeAction implements Serializable {
    private Logger logger = LoggerFactory.getLogger(HomeAction.class);

    @EJB
    private ResearchAreaService researchAreaService;
    private List<ResearchArea> researchAreaList;


    public List<ResearchArea> getResearchAreaList(){
        return this.researchAreaList;
    }

    @PostConstruct
    public void onBeanCreation(){
       logger.info("\n\n_______________________HomeAction Bean created__________________________\n\n");
       this.researchAreaList = researchAreaService.getResearchAreaList();
    }

    @PreDestroy
    public void onBeanDestroy(){
        logger.info("\n\n______________________HomeAction Bean destroyed____________________________\n\n");
    }
}
