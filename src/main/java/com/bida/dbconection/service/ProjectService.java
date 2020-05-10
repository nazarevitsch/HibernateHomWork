package com.bida.dbconection.service;

import com.bida.dbconection.domain.Project;
import com.bida.dbconection.repository.ProjectDAO;

import java.util.List;

public class ProjectService {
    private final ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO){
        this.projectDAO = projectDAO;
    }

    public List<Project> findAllProjects(){
        return projectDAO.findAllProjects();
    }
}
