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
        return projectDAO.selectAllEntity();
    }

    public Project findProjectById(Long id){return projectDAO.getEntity(id);}

    public void createProject(Project project){
        projectDAO.save(project);
    }

    public void deleteProject(Long id){
        projectDAO.delete(id);
    }

    public void updateProject(Project project, Long id){
        projectDAO.update(project, id);
    }
}
