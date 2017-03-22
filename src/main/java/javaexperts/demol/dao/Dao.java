package javaexperts.demol.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Dao {

    private static EntityManagerFactory entityManagerFactory = maakEntityManagerFactory();

    protected EntityManager entityManager = entityManagerFactory.createEntityManager();

    private static EntityManagerFactory maakEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("demol");
    }

    protected void close() {
        entityManager.close();
    }

}
