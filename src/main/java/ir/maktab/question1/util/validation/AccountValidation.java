package ir.maktab.question1.util.validation;

import ir.maktab.question1.util.exception.AccountException;

public class AccountValidation {
    public static void validCardNumber(String cardNumber) throws AccountException {
        if (!cardNumber.equals("") && cardNumber.matches("^[0-9]{16}"))
            return;
        throw new AccountException("Card number should be 16 digits");
    }
}
