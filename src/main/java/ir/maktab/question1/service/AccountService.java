package ir.maktab.question1.service;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.util.exception.AccountException;

import java.util.Date;

public interface AccountService {
    void createNewAccount(Account account) throws AccountException;

    void withdraw(Account account, double amount);

    void deposit(Account account, double amount);

    Account getAccount(String type, String cardNumber, String accountNumber, Date openingDate, Date expiryDate,
                       double amount, int cvv2) throws AccountException;
}
