package com.bida.dbconection.service;

import com.bida.dbconection.domain.Company;
import com.bida.dbconection.repository.CompanyDAO;

import java.util.List;

public class CompanyService {

    private final CompanyDAO companyDAO;

    public CompanyService(CompanyDAO companyDAO){
        this.companyDAO = companyDAO;
    }

    public List<Company> findAllCompanies(){
        List<Company> companies = companyDAO.selectAllEntity();
        System.out.println(companies);
        return companies;
    }
}
