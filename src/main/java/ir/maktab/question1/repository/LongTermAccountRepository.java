package ir.maktab.question1.repository;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.data.LongTermAccount;

import javax.persistence.EntityManager;

public class LongTermAccountRepository {
    public void creat(LongTermAccount longTermAccount) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(longTermAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
