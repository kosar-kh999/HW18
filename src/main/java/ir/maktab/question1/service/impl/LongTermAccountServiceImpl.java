package ir.maktab.question1.service.impl;

import ir.maktab.question1.data.LongTermAccount;
import ir.maktab.question1.repository.LongTermAccountRepository;
import ir.maktab.question1.service.LongTermAccountService;

public class LongTermAccountServiceImpl implements LongTermAccountService {
    private static LongTermAccountRepository longTermAccountRepository = new LongTermAccountRepository();

    @Override
    public void creat(LongTermAccount longTermAccount) {
        longTermAccountRepository.creat(longTermAccount);
    }
}
