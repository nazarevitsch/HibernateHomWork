package com.bida.dbconection.repository;

import com.bida.dbconection.domain.Project;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO extends GenericDAO{

    private static final String selectAllProjectStartDateNameAmountDevelopers = "select start_date, name , count(developer_id) as developers_amount from projects p\n" +
            "join developers_projects dp on dp.project_id = p.id_project\n" +
            "group by name, start_date";

    public List<Project> findAllProjects(){
        EntityManager entityManager = getEntityManager();
        List<Project> projects = (List<Project>) entityManager.createNativeQuery(selectAllProjectStartDateNameAmountDevelopers, Project.class)
                .getResultList();
        entityManager.close();
        return projects;
    }
}
