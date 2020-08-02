package com.bida.dbconection.web;

import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.domain.Project;
import com.bida.dbconection.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developer_project_add")
public class DeveloperProjectAddController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Developer> developers = serviceFactory.getDeveloperService().selectAllDevelopers();
        List<Project> projects = serviceFactory.getProjectService().findAllProjects();
        req.setAttribute("developers", developers);
        req.setAttribute("projects", projects);
        req.getRequestDispatcher("developer-project-add.jsp").forward(req, resp);
    }
}
