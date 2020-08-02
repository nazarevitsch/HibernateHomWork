package com.bida.dbconection.web;

import com.bida.dbconection.domain.Company;
import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(urlPatterns = "/developer_edit")
public class DeveloperEditController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long developerId = Long.parseLong(req.getParameter("id"));
        Developer developer = serviceFactory.getDeveloperService().findDeveloperById(developerId);
        req.setAttribute("developer", developer);
        List<Company> companies = serviceFactory.getCompanyService().findAllCompanies();
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("developer-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Developer developer = new Developer();
        developer.setId(Long.valueOf(req.getParameter("id")));
        developer.setName(req.getParameter("name"));
        developer.setSex(req.getParameter("sex"));
        developer.setAge(Integer.parseInt(req.getParameter("age")));
        developer.setItCompanyId(Long.parseLong(req.getParameter("itCompanyId")));
        developer.setSalary(BigDecimal.valueOf(Long.valueOf(req.getParameter("salary"))));
        System.out.println(developer);
        serviceFactory.getDeveloperService().updateDeveloper(developer);
        resp.sendRedirect("/servlet/developers");
    }
}
