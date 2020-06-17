package com.bida.dbconection.service;

import com.bida.dbconection.domain.DeveloperProject;
import com.bida.dbconection.repository.DevelopersProjectsDAO;

import java.util.List;

public class DevelopersProjectsService {

    private final DevelopersProjectsDAO developersProjectsDAO;

    public DevelopersProjectsService(DevelopersProjectsDAO developersProjectsDAO){
        this.developersProjectsDAO = developersProjectsDAO;
    }

    public DeveloperProject findDeveloperProjectById(long id){
        return developersProjectsDAO.getEntity(id);
    }

    public List<DeveloperProject> findAll(){
        return developersProjectsDAO.selectAllEntity();
    }

    public void createDeveloperProject(DeveloperProject developerProject){
        developersProjectsDAO.save(developerProject);
    }

    public void deleteDeveloperProject(Long id){
        developersProjectsDAO.delete(id);
    }

    public void updateDeveloperProject(DeveloperProject developerProject, Long id){
        developersProjectsDAO.update(developerProject, id);
    }
}
