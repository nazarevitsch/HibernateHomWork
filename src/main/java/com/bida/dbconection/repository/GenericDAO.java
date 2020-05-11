package com.bida.dbconection.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {

    private EntityManager entityManager;

    GenericDAO(){
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e){
            Logger logger = LoggerFactory.getLogger(GenericDAO.class);
            logger.error("Wrong PASSWORD, USERNAME, or URL");
            System.exit(1);
        }
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}
