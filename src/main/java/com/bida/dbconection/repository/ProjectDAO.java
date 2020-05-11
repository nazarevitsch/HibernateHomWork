package com.bida.dbconection.repository;

import com.bida.dbconection.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ProjectDAO extends GenericDAO{

    private static final String selectAllProjectStartDateNameAmountDevelopers = "select id_project, start_date, end_date, name , count(developer_id) as developers_amount from projects p\n" +
            "join developers_projects dp on dp.project_id = p.id_project\n" +
            "group by name, start_date, id_project, end_date";

    public List<Project> findAllProjects() {
        List<Project> projects = null;
        try {
            EntityManager entityManager = getEntityManager();
            projects = (List<Project>) entityManager.createNativeQuery(selectAllProjectStartDateNameAmountDevelopers, Project.class)
                    .getResultList();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(ProjectDAO.class);
            logger.error("ERROR with find all projects!");
        }
        return projects;
    }
}
