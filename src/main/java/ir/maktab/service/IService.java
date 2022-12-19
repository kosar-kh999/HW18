package ir.maktab.service;

import ir.maktab.data.Account;

public interface IService<T extends Account> {
    void createNewAccount(T account);
}
