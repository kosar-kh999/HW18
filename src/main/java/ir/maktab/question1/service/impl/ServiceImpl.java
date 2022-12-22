package ir.maktab.question1.service.impl;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.data.CurrentAccount;
import ir.maktab.question1.data.LongTermAccount;
import ir.maktab.question1.data.ShortTermAccount;
import ir.maktab.question1.repository.IRepository;
import ir.maktab.question1.repository.impl.AccountRepositoryImpl;
import ir.maktab.question1.service.IService;
import ir.maktab.question1.util.exception.AccountException;
import ir.maktab.question1.util.validation.AccountValidation;

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

    public static Account getAccount(String type) {
        if (type == null) {
            return null;
        } else if (type.equalsIgnoreCase("CurrentAccount")) {
            return new CurrentAccount();
        } else if (type.equalsIgnoreCase("LongTermAccount")) {
            return new LongTermAccount();
        } else if (type.equalsIgnoreCase("ShortTermAccount")) {
            return new ShortTermAccount();
        }
        return null;
    }
}
