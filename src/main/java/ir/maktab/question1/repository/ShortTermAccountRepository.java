package ir.maktab.question1.repository;

import ir.maktab.question1.data.ShortTermAccount;

import javax.persistence.EntityManager;

public class ShortTermAccountRepository {
    public void creat(ShortTermAccount shortTermAccount) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(shortTermAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
