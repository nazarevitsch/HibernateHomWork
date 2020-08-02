package com.bida.dbconection.web;

import com.bida.dbconection.domain.Project;
import com.bida.dbconection.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/project_edit")
public class ProjectEditController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.parseLong(req.getParameter("id"));
        Project project = serviceFactory.getProjectService().findProjectById(projectId);
        req.setAttribute("project", project);
        req.getRequestDispatcher("project-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Project project = new Project();
        project.setId(Long.valueOf(req.getParameter("id")));
        project.setName(req.getParameter("name"));
        project.setStartDate(Date.valueOf(req.getParameter("startDate")));
        project.setEndDate(Date.valueOf(req.getParameter("endDate")));
        serviceFactory.getProjectService().updateProject(project, project.getId());
        resp.sendRedirect("/servlet/projects");
    }
}
