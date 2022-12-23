package ir.maktab.question1.view;

import ir.maktab.question1.data.Account;
import ir.maktab.question1.data.Person;
import ir.maktab.question1.service.AccountService;
import ir.maktab.question1.service.PersonService;
import ir.maktab.question1.service.impl.AccountServiceImpl;
import ir.maktab.question1.service.impl.PersonServiceImpl;
import ir.maktab.question1.util.exception.AccountException;
import ir.maktab.question1.util.validation.AccountValidation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AccountService service = new AccountServiceImpl();
    private static final Account account = new Account();
    private static final PersonService personService = new PersonServiceImpl();
    private static Person person;

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        System.out.println("Enter your first name : ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name : ");
        String lastName = scanner.nextLine();

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
        account.setAccountNumber(accountNumber);

        System.out.println("Enter your opening date : ");
        LocalDate openingDate = getDate();
        Date opening = Date.from(openingDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        account.setOpeningDate(opening);

        System.out.println("Your expire date is : ");
        LocalDate date = openingDate.plusYears(4);
        Date expire = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        account.setExpiryDate(expire);
        System.out.println(expire);

        System.out.println("Enter your amount : ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.setAmount(amount);

        System.out.println("your cvv2 is : ");
        int min = 1000;
        int max = 9999;
        account.setCvv2((int) (Math.random() * (max - min + 1) + min));
        System.out.println(account.getCvv2());

        do {
            System.out.println("enter your type of account :");
            String type = scanner.nextLine();
            try {
                System.out.println("account information : \t" + type + "\t" + firstName + "\t" + lastName);
                System.out.println(service.getAccount(type, account.getCardNumber(), accountNumber, opening, expire, amount,
                        account.getCvv2()));
                service.createNewAccount(account);
                accounts.add(account);
                person = new Person(firstName, lastName, accounts);
                personService.creat(person);
                break;
            } catch (AccountException e) {
                System.out.println("enter correct type of account ");
            }
        } while (true);
    }

    public static LocalDate getDate() {
        System.out.println("enter year : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("enter month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("enter day:");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

}
