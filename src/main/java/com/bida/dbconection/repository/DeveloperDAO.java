package com.bida.dbconection.repository;

import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.domain.ProgramingLanguage;
import com.bida.dbconection.domain.SkillsLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class DeveloperDAO extends GenericDAO<Developer, Long> {


    private static final String selectAllDevelopersByLanguageSkills = "" +
            "select distinct id_developer, name, age, sex, it_company_id, salary from developers\n" +
            "join developers_skills ds ON developers.id_developer = ds.developer_id\n" +
            "join skills s ON s.id_skills = ds.skill_id\n" +
            "where s.programing_language = :programingLanguage";

    private static final String selectAllDevelopersByLevelSkills = "" +
            "select distinct id_developer, name, age, sex, it_company_id, salary from developers\n" +
            "join developers_skills ds ON developers.id_developer = ds.developer_id\n" +
            "join skills s ON s.id_skills = ds.skill_id\n" +
            "where s.level = :skillsLevel";

    private static final String selectDevelopersByProject = "select distinct * from developers\n" +
            "join developers_projects dp on developers.id_developer = dp.developer_id\n" +
            "join projects p on dp.project_id = p.id_project\n" +
            "where p.id_project = :id";

    private static final String selectDevelopersSalaryByIdProject = "select cost from\n" +
            "(select project_id, sum(salary) as cost from developers_projects\n" +
            "join developers on developers.id_developer = developers_projects.developer_id\n" +
            "group by project_id) as foo where project_id = :id";

    private static final String selectAllDeveloper = "select * from developers";

    public List<Developer> findAllDevelopersByProgramingLanguage(ProgramingLanguage programingLanguage) {
        List<Developer> developers = null;
        try {
            EntityManager entityManager = getEntityManager();
            developers = (List<Developer>) entityManager.createNativeQuery(selectAllDevelopersByLanguageSkills, Developer.class)
                    .setParameter("programingLanguage", programingLanguage.getName())
                    .getResultList();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with find all developers by programing language Developer!");
        }
        return developers;
    }

    public List<Developer> findAllDevelopersBySkillsLevel(SkillsLevel skillsLevel) {
        List<Developer> developers = null;
        try {
            EntityManager entityManager = getEntityManager();
            developers = (List<Developer>) entityManager.createNativeQuery(selectAllDevelopersByLevelSkills, Developer.class)
                    .setParameter("skillsLevel", skillsLevel.getName())
                    .getResultList();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with find all developers by skills level Developer!");
        }
        return developers;
    }

    public List<Developer> findAllDevelopersByProjectId(long projectId) {
        List<Developer> developers = null;
        try {
            EntityManager entityManager = getEntityManager();
            developers = (List<Developer>) entityManager.createNativeQuery(selectDevelopersByProject, Developer.class)
                    .setParameter("id", projectId)
                    .getResultList();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with find all developers by project id Developer!");
        }
        return developers;
    }

    public BigDecimal findDevelopersSalaryByIdProject(long projectId) {
        BigInteger salarySum = null;
        try {
            EntityManager entityManager = getEntityManager();
            salarySum = (BigInteger) entityManager.createNativeQuery(selectDevelopersSalaryByIdProject)
                    .setParameter("id", projectId)
                    .getSingleResult();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with find all salary of developers by project id Developer!");
        }
        return new BigDecimal(salarySum);
    }
}
