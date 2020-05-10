package com.bida.dbconection.repository;

import com.bida.dbconection.domain.Developer;
import com.bida.dbconection.domain.ProgramingLanguage;
import com.bida.dbconection.domain.SkillsLevel;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class DeveloperDAO extends GenericDAO {

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

    public void save(Developer developer){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(developer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Developer developer, Long id){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Developer developerFromDB = entityManager.find(Developer.class, id);
        entityManager.merge(developer);
        entityManager.persist(developerFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Developer developerFromDB = entityManager.find(Developer.class, id);
        entityManager.remove(developerFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Developer> selectAllDevelopers(){
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createNativeQuery(selectAllDeveloper, Developer.class)
                .getResultList();
        entityManager.close();
        return developers;
    }

    public List<Developer> findAllDevelopersByProgramingLanguage(ProgramingLanguage programingLanguage) {
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createNativeQuery(selectAllDevelopersByLanguageSkills, Developer.class)
                .setParameter("programingLanguage", programingLanguage.getName())
                .getResultList();
        entityManager.close();
        return developers;
    }

    public List<Developer> findAllDevelopersBySkillsLevel(SkillsLevel skillsLevel) {
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createNativeQuery(selectAllDevelopersByLevelSkills, Developer.class)
                .setParameter("skillsLevel", skillsLevel.getName())
                .getResultList();
        entityManager.close();
        return developers;
    }

    public List<Developer> findAllDevelopersByProjectId(long projectId) {
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createNativeQuery(selectDevelopersByProject, Developer.class)
                .setParameter("id", projectId)
                .getResultList();
        entityManager.close();
        return developers;
    }

    public BigDecimal findDevelopersSalaryByIdProject(long projectId){
        EntityManager entityManager = getEntityManager();
        BigInteger salarySum = (BigInteger) entityManager.createNativeQuery(selectDevelopersSalaryByIdProject)
                .setParameter("id", projectId)
                .getSingleResult();
        entityManager.close();
        return new BigDecimal(salarySum);
    }

}
