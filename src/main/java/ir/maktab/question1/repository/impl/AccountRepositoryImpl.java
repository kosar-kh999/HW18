package ir.maktab.question1.repository.impl;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.repository.EntityManagerFactory;
import ir.maktab.question1.repository.IRepository;
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

    @Override
    public void update(int id, double credit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T account = (T) session.get(Account.class, id);
        account.setAmount(credit);
        session.update(account);
        transaction.commit();
        session.close();
    }
}
