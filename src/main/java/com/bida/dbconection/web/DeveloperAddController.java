package com.bida.dbconection.web;

import com.bida.dbconection.domain.Company;
import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.service.CompanyService;
import com.bida.dbconection.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developer_add")
public class DeveloperAddController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = serviceFactory.getCompanyService().findAllCompanies();
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("developer-add.jsp").forward(req, resp);
    }
}
