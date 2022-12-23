package ir.maktab.question1.service.impl;

import ir.maktab.question1.data.ShortTermAccount;
import ir.maktab.question1.repository.ShortTermAccountRepository;
import ir.maktab.question1.service.ShortTermAccountService;

public class ShortTermAccountServiceImpl implements ShortTermAccountService {
    private static ShortTermAccountRepository shortTermAccountRepository = new ShortTermAccountRepository();

    @Override
    public void creat(ShortTermAccount shortTermAccount) {
        shortTermAccountRepository.creat(shortTermAccount);
    }
}
