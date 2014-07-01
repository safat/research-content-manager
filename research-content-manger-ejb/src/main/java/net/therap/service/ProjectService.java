package net.therap.service;

import net.therap.dao.ProjectDao;
import net.therap.domain.Project;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/23/14
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ProjectService {

  @EJB
  private ProjectDao projectDao;

    public Project getProjectById(int projectId){
      return projectDao.getProjectById(projectId);
  }

    public List<Project> getRunningProjects() {
        return projectDao.getRunningProjects();
    }

    public void updateProject(int projectId) {
        projectDao.updateProject(projectId);
    }
}
