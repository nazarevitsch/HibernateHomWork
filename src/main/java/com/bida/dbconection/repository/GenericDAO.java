package com.bida.dbconection.repository;

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
            logger.error("Wrong PASSWORD, USERNAME, or URL in GenericDAO CAUSE:{}", e.getMessage());
            System.exit(1);
        }
    }

    public T getEntity(Long id){
        T entity = null;
        try {
            EntityManager entityManager = getEntityManager();
            entity = (T) entityManager.find( persistentClass, id);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with find all GenericDAO! CAUSE:{}", e.getMessage());
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public List<T> selectAllEntity(){
        List<T> entities = null;
        try {
            EntityManager entityManager = getEntityManager();
            System.out.println(persistentClass.getSimpleName());
            entities = (List<T>) entityManager.createQuery("select t from " + persistentClass.getSimpleName() + " t").getResultList();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with find all GenericDAO! CAUSE:{}", e.getMessage());
        } finally {
            entityManager.close();
        }
        return entities;
    }

    public void save(T entity) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger logger = LoggerFactory.getLogger(GenericDAO.class);
            logger.error("ERROR with save GenericDAO! CAUSE:{}", e.getMessage());
        } finally {
            entityManager.close();
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
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger logger = LoggerFactory.getLogger(GenericDAO.class);
            logger.error("ERROR with update GenericDAO! CAUSE:{}", e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void delete(Long id){
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            T developerFromDB = (T) entityManager.find(persistentClass, id);
            entityManager.remove(developerFromDB);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            Logger logger = LoggerFactory.getLogger(DeveloperDAO.class);
            logger.error("ERROR with delete GenericDAO! CAUSE:{}", e.getMessage());
        } finally {
            entityManager.close();
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
