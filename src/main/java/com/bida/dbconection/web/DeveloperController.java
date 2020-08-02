package com.bida.dbconection.web;

import com.bida.dbconection.domain.Developer;
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

@WebServlet(urlPatterns = "/developers")
public class DeveloperController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        if(req.getParameterMap().containsKey("id")){
            Long developerId = Long.parseLong(req.getParameter("id"));
            Developer developer = serviceFactory.getDeveloperService().findDeveloperById(developerId);
            PrintWriter writer = resp.getWriter();
            writer.println(objectMapper.writeValueAsString(developer));
        }
        else {
            List<Developer> developers = serviceFactory.getDeveloperService().selectAllDevelopers();
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("developer-list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Developer developer = new Developer();
        developer.setName(req.getParameter("name"));
        developer.setSex(req.getParameter("sex"));
        developer.setAge(Integer.parseInt(req.getParameter("age")));
        developer.setItCompanyId(Long.parseLong(req.getParameter("itCompanyId")));
        developer.setSalary(BigDecimal.valueOf(Long.valueOf(req.getParameter("salary"))));
        System.out.println(developer);
        serviceFactory.getDeveloperService().createDeveloper(developer);
        resp.sendRedirect("/servlet/developers");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long developerId = Long.parseLong(req.getParameter("id"));
        serviceFactory.getDeveloperService().deleteDeveloper(developerId);
        resp.setStatus(204);
    }
}