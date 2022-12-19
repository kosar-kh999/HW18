package ir.maktab.repository.impl;

import ir.maktab.data.Account;
import ir.maktab.repository.EntityManagerFactory;
import ir.maktab.repository.IRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountRepositoryImpl<T extends Account> implements IRepository<T> {
    public static SessionFactory sessionFactory = EntityManagerFactory.getInstance().getSessionFactory();

    @Override
    public void creat(T account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }
}
