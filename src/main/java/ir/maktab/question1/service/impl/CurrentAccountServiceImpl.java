package ir.maktab.question1.service.impl;

import ir.maktab.question1.data.CurrentAccount;
import ir.maktab.question1.repository.CurrentAccountRepository;
import ir.maktab.question1.service.CurrentAccountService;

public class CurrentAccountServiceImpl implements CurrentAccountService {
    private static CurrentAccountRepository currentAccountRepository = new CurrentAccountRepository();

    @Override
    public void creat(CurrentAccount currentAccount) {
        currentAccountRepository.creat(currentAccount);
    }
}
