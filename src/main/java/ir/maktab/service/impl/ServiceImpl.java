package ir.maktab.service.impl;

import ir.maktab.data.Account;
import ir.maktab.data.CurrentAccount;
import ir.maktab.repository.IRepository;
import ir.maktab.repository.impl.AccountRepositoryImpl;
import ir.maktab.service.IService;
import ir.maktab.util.exception.AccountException;
import ir.maktab.util.validation.AccountValidation;

public class ServiceImpl<T extends Account> implements IService<T> {
    IRepository<T> accountRepository = new AccountRepositoryImpl<>();

    @Override
    public void createNewAccount(T account) throws AccountException {
        AccountValidation.validCardNumber(account.getCardNumber());
        accountRepository.creat(account);
    }

    @Override
    public void withdraw(T account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        }
        if (amount > account.getAmount()) {
            throw new RuntimeException("Your balance is not enough");
        }
        account.setAmount(account.getAmount() - amount);
        accountRepository.update(account.getId(), account.getAmount());
    }

    @Override
    public void deposit(T account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not deposit a negative amount");
        }
        account.setAmount(account.getAmount() + amount);
        accountRepository.update(account.getId(), account.getAmount());
    }

    public static Account getAccount(String type,Account account){
        if ("CurrentAccount".equalsIgnoreCase(type)) return new CurrentAccount()
    }
}
