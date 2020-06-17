package com.bida.dbconection.web;

import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.domain.Project;
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
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = "/projects")
public class ProjectController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterMap().containsKey("id")){
            resp.setContentType("application/json");
            Long projectId = Long.parseLong(req.getParameter("id"));
            Project project = serviceFactory.getProjectService().findProjectById(projectId);
            PrintWriter writer = resp.getWriter();
            writer.println(objectMapper.writeValueAsString(project));
        }
        else {
            List<Project> projects = serviceFactory.getProjectService().findAllProjects();
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("project-list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Project project = new Project();
        project.setName(req.getParameter("name"));
        project.setStartDate(Date.valueOf(req.getParameter("startDate")));
        project.setEndDate(Date.valueOf(req.getParameter("endDate")));
        serviceFactory.getProjectService().createProject(project);
        resp.sendRedirect("/servlet/projects");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.parseLong(req.getParameter("id"));
        serviceFactory.getProjectService().deleteProject(projectId);
        resp.setStatus(204);
    }
}
