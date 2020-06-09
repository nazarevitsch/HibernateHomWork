package com.bida.dbconection.service;

import com.bida.dbconection.domain.DevelopersProjects;
import com.bida.dbconection.domain.Project;
import com.bida.dbconection.repository.DevelopersProjectsDAO;

import java.util.List;

public class DevelopersProjectsService {

    private final DevelopersProjectsDAO developersProjectsDAO;

    public DevelopersProjectsService(DevelopersProjectsDAO developersProjectsDAO){
        this.developersProjectsDAO = developersProjectsDAO;
    }

    public List<DevelopersProjects> findAll(){
        return developersProjectsDAO.selectAllEntity();
    }

    public void createDeveloperProject(DevelopersProjects developersProjects){
        developersProjectsDAO.save(developersProjects);
    }

    public void deleteDeveloperProject(Long id){
        developersProjectsDAO.delete(id);
    }

    public void updateDeveloperProject(DevelopersProjects developerProject, Long id){
        developersProjectsDAO.update(developerProject, id);
    }
}
