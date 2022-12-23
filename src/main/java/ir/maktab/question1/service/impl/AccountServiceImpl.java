package ir.maktab.question1.service.impl;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.data.CurrentAccount;
import ir.maktab.question1.data.LongTermAccount;
import ir.maktab.question1.data.ShortTermAccount;
import ir.maktab.question1.repository.AccountRepository;
import ir.maktab.question1.service.AccountService;
import ir.maktab.question1.util.exception.AccountException;
import ir.maktab.question1.util.validation.AccountValidation;

import java.util.Date;

public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository = new AccountRepository();

    @Override
    public void createNewAccount(Account account) throws AccountException {
        AccountValidation.validCardNumber(account.getCardNumber());
        accountRepository.creat(account);
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        }
        if (amount > account.getAmount()) {
            throw new RuntimeException("Your balance is not enough");
        }
        account.setAmount(account.getAmount() - amount);
        accountRepository.update(account);
    }

    @Override
    public void deposit(Account account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not deposit a negative amount");
        }
        account.setAmount(account.getAmount() + amount);
        accountRepository.update(account);
    }

    public Account getAccount(String type, String cardNumber, String accountNumber, Date openingDate, Date expiryDate,
                              double amount, int cvv2) throws AccountException {
        boolean isCheckBook = true;
        double annualProfit = 30000;
        double profit = 10000;
        if (amount < 50000) {
            return null;
        } else if (type.equalsIgnoreCase("CurrentAccount") && amount >= 100000) {
            return new CurrentAccount(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2, isCheckBook);
        } else if (type.equalsIgnoreCase("LongTermAccount") && amount >= 100000) {
            return new LongTermAccount(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2, annualProfit);
        } else if (type.equalsIgnoreCase("ShortTermAccount") && amount >= 50000) {
            return new ShortTermAccount(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2, profit);
        }
        throw new AccountException("Enter correct type : ");
    }
}
