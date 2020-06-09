package com.bida.dbconection.service;

import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.domain.ProgramingLanguage;
import com.bida.dbconection.domain.SkillsLevel;
import com.bida.dbconection.repository.DeveloperDAO;

import java.math.BigDecimal;
import java.util.List;

public class DeveloperService {

    private final DeveloperDAO developerDAO;

    public DeveloperService(DeveloperDAO developerDAO){
        this.developerDAO = developerDAO;
    }

    public void createDeveloper(Developer developer){
        developerDAO.save(developer);
    }

    public void updateDeveloper(Developer developer){
        developerDAO.update(developer, developer.getId());
    }

    public void deleteDeveloper(Long id){
        developerDAO.delete(id);
    }

    public List<Developer> selectAllDevelopers(){
        return developerDAO.selectAllEntity();
    }

    public List<Developer> findAllDevelopersByProgramingLanguage(ProgramingLanguage programingLanguage) {
        return developerDAO.findAllDevelopersByProgramingLanguage(programingLanguage);
    }

    public List<Developer> findAllDevelopersBySkillLevel(SkillsLevel skillLevel) {
        return developerDAO.findAllDevelopersBySkillsLevel(skillLevel);
    }

    public List<Developer> findAllDevelopersByProjectId(long projectId) {
        return developerDAO.findAllDevelopersByProjectId(projectId);
    }

    public BigDecimal findDevelopersSalaryByIdProject(long projectId){
        return developerDAO.findDevelopersSalaryByIdProject(projectId);
    }
}
