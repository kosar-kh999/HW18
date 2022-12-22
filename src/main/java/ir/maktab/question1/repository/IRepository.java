package ir.maktab.question1.repository;

import ir.maktab.question1.data.Account;

public interface IRepository<T extends Account> {
    void creat(T account);
    void update(int id, double credit);
}
