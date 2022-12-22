package ir.maktab.question1.view;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.service.impl.ServiceImpl;
import ir.maktab.question1.util.exception.AccountException;
import ir.maktab.question1.util.validation.AccountValidation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ServiceImpl service = new ServiceImpl();
    private static Account account;

    public static void main(String[] args) {
        do {
            System.out.println("Enter your card number : ");
            String cardNumber = scanner.nextLine();
            try {
                AccountValidation.validCardNumber(cardNumber);
                account.setCardNumber(cardNumber);
                break;
            } catch (AccountException e) {
                System.out.println("Card number should be 16 ! ");
            }
        } while (true);
        System.out.println("Enter your account number : ");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter your opening date : ");
        LocalDate openingDate = getDate();
        Date opening = Date.from(openingDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("Your expire date is : ");
        LocalDate date = openingDate.plusYears(4);
        Date expire = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("Enter your amount : ");
        Double amount = Double.valueOf(scanner.nextLine());
    }

    public static LocalDate getDate() {
        System.out.println("enter year : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("enter month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("enter day:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }
}
