package ir.maktab.repository;

import ir.maktab.data.Account;

public interface IRepository<T extends Account> {
    void creat(T account);
    void update(int id, double credit);
}
