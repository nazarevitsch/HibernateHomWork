package com.bida.dbconection;

import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.domain.ProgramingLanguage;
import com.bida.dbconection.domain.Sex;
import com.bida.dbconection.domain.SkillsLevel;
import com.bida.dbconection.service.ServiceFactory;

public class Main {

    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {
//        serviceFactory.getDeveloperService().createDeveloper(new Developer("SARAN", 34, Sex.MALE, 2, new BigDecimal(2345)));
//        serviceFactory.getDeveloperService().updateDeveloper(new Developer(11, "Kostir", 34, Sex.MALE, 2, new BigDecimal(2345)));

        System.out.println(serviceFactory.getDeveloperService().selectAllDevelopers());
        System.out.println(serviceFactory.getDeveloperService().findAllDevelopersByProgramingLanguage(ProgramingLanguage.Java));
        System.out.println(serviceFactory.getDeveloperService().findAllDevelopersBySkillLevel(SkillsLevel.SENIOR));
        System.out.println(serviceFactory.getDeveloperService().findAllDevelopersByProjectId(2));
        System.out.println(serviceFactory.getDeveloperService().findDevelopersSalaryByIdProject(1));

        System.out.println(serviceFactory.getProjectService().findAllProjects());
    }
}
