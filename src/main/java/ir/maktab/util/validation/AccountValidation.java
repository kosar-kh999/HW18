package ir.maktab.util.validation;

import ir.maktab.util.exception.AccountException;

import javax.xml.bind.ValidationException;

public class AccountValidation {
    public static void validCardNumber(String cardNumber) throws AccountException {
        if (!cardNumber.equals("") && cardNumber.matches("^[0-9]{16}"))
            return;
        throw new AccountException("Card number should be 16 digits");
    }
}
