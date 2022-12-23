package ir.maktab.question1.repository;

import ir.maktab.question1.data.Person;

import javax.persistence.EntityManager;

public class PersonRepository {
    public void creat(Person person) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
