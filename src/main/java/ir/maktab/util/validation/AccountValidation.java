package ir.maktab.util.validation;

import javax.xml.bind.ValidationException;

public class AccountValidation {
    public static void validCardNumber(String cardNumber) throws ValidationException {
        if (!cardNumber.equals("") && cardNumber.matches("^[0-9]{16}"))
            return;
        throw new ValidationException("Card number should be 16 digits");
    }
}
