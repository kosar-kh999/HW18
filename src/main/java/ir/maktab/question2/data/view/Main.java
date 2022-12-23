package ir.maktab.question2.data.view;

import ir.maktab.question2.data.design.Product;
import ir.maktab.question2.data.design.Subscriber;

import java.util.Scanner;

public class Main {
    private static Product product = new Product();
    private static Subscriber subscriber;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter your item");
        String productName = scanner.nextLine();
        System.out.println("Your item is not available now.");
        product = new Product(productName);

        System.out.println("  Press 1 --> sign up");
        System.out.println("  Press 2 --> sign out");
        int secondChoice = Integer.parseInt(scanner.nextLine());
        switch (secondChoice) {
            case 1 -> {
                System.out.println("Enter your name");
                String name = scanner.nextLine();
                subscriber = new Subscriber(name);
                product.signUpObserver(subscriber);
            }
            case 2 -> {
                product.signOutObserver(subscriber);
                System.out.println("you have signed out");
            }
            default -> System.exit(0);
        }

        product.setAvailability("Available");
    }

}
