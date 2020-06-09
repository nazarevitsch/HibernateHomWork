package com.bida.dbconection;

import com.bida.dbconection.domain.*;
import com.bida.dbconection.service.ServiceFactory;
import java.math.BigDecimal;


public class Main {

    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {
//        serviceFactory.getDeveloperService().createDeveloper(new Developer("SARAN", 34, Sex.MALE, 2, new BigDecimal(2345)));
//        serviceFactory.getDeveloperService().updateDeveloper(new Developer(11, "Kostir", 34, Sex.MALE, 2, new BigDecimal(2345)));
//        serviceFactory.getDeveloperService().deleteDeveloper(7L);

//        System.out.println(serviceFactory.getDeveloperService().selectAllDevelopers());

//        System.out.println(serviceFactory.getDeveloperService().findAllDevelopersByProgramingLanguage(ProgramingLanguage.Java));
//        System.out.println(serviceFactory.getDeveloperService().findAllDevelopersBySkillLevel(SkillsLevel.SENIOR));
//        System.out.println(serviceFactory.getDeveloperService().findAllDevelopersByProjectId(2));
//        System.out.println(serviceFactory.getDeveloperService().findDevelopersSalaryByIdProject(1));
//
//        System.out.println(serviceFactory.getProjectService().findAllProjects());
        System.out.println(serviceFactory.getDevelopersProjectsService().findAll());
        serviceFactory.getDevelopersProjectsService().createDeveloperProject(new DevelopersProjects(1, 4));
    }
}
