package ir.maktab.question1.repository;

import ir.maktab.question1.data.CurrentAccount;

import javax.persistence.EntityManager;

public class CurrentAccountRepository {
    public void creat(CurrentAccount currentAccount) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(currentAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
