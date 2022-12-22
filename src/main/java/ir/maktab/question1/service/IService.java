package ir.maktab.question1.service;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.util.exception.AccountException;

public interface IService<T extends Account> {
    void createNewAccount(T account) throws AccountException;

    void withdraw(T account, double amount);

    void deposit(T account, double amount);
}
