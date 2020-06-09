package com.bida.dbconection.repository;

import com.bida.dbconection.domain.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAO<T, K> {

    private T type;
    private K key;
    private Class<T> persistentClass;
    private EntityManager entityManager;

    GenericDAO(){
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e){
            Logger logger = LoggerFactory.getLogger(GenericDAO.class);
            logger.error("Wrong PASSWORD, USERNAME, or URL in GenericDAO");
            System.exit(1);
        }
    }

    public List<T> selectAllEntity(){
        List<T> entities = null;
        try {
            EntityManager entityManager = getEntityManager();
            entities = (List<T>) entityManager.createQuery("select t from " + persistentClass.getSimpleName() + " t").getResultList();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with find all GenericDAO!");
        }
        return entities;
    }

    public void save(T entity) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(GenericDAO.class);
            logger.error("ERROR with save GenericDAO!");
        }
    }

    public void update(T entity, Long id) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            T entityFromDB = (T) entityManager.find(persistentClass, id);
            entityManager.merge(entity);
            entityManager.persist(entityFromDB);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(GenericDAO.class);
            logger.error("ERROR with update GenericDAO!");
        }
    }

    public void delete(Long id){
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            T developerFromDB = (T) entityManager.find(persistentClass, id);
            entityManager.remove(developerFromDB);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with delete GenericDAO!");
        }
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
