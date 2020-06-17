package com.bida.dbconection.web;

import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.domain.DeveloperProject;
import com.bida.dbconection.service.ServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(urlPatterns = "/developersProjects")
public class DeveloperProjectController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterMap().containsKey("id")){
            resp.setContentType("application/json");
            Long developerProjectId = Long.parseLong(req.getParameter("id"));
            DeveloperProject developerProject = serviceFactory.getDevelopersProjectsService().findDeveloperProjectById(developerProjectId);
            PrintWriter writer = resp.getWriter();
            writer.println(objectMapper.writeValueAsString(developerProject));
        }
        else {
            List<DeveloperProject> developersProjects = serviceFactory.getDevelopersProjectsService().findAll();
//            System.out.println(developersProjects.size());
            req.setAttribute("developersProjects", developersProjects);
            req.getRequestDispatcher("developer-project-list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeveloperProject developerProject = new DeveloperProject();
        developerProject.setDeveloperId(Integer.parseInt(req.getParameter("developerId")));
        developerProject.setProjectId(Integer.parseInt(req.getParameter("projectId")));
        serviceFactory.getDevelopersProjectsService().createDeveloperProject(developerProject);
        resp.sendRedirect("/servlet/developersProjects");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long developerProjectId = Long.parseLong(req.getParameter("id"));
        serviceFactory.getDevelopersProjectsService().deleteDeveloperProject(developerProjectId);
        resp.setStatus(204);
    }
}
