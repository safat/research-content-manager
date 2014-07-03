package net.therap.controller;

import net.therap.domain.Project;
import net.therap.service.ProjectService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shakhawat.hossain on 7/1/14.
 */
@WebServlet(urlPatterns = "/project")
public class ProjectController extends HttpServlet {

    @EJB
    private ProjectService projectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Project project =  projectService.getProjectById(1);
        resp.getWriter().write(project.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
