package ir.maktab.service;

import ir.maktab.data.Account;
import ir.maktab.util.exception.AccountException;

public interface IService<T extends Account> {
    void createNewAccount(T account) throws AccountException;

    void withdraw(T account, double amount);

    void deposit(T account, double amount);
}
