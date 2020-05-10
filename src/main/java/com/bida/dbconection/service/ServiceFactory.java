package com.bida.dbconection.service;

import com.bida.dbconection.repository.DeveloperDAO;
import com.bida.dbconection.repository.ProjectDAO;

public class ServiceFactory {

    public DeveloperService getDeveloperService(){
        return new DeveloperService(new DeveloperDAO());
    }

    public ProjectService getProjectService(){
        return new ProjectService(new ProjectDAO());
    }
}
