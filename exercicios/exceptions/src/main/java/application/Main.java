package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw Limit: : ");
        double withdrawLimit = sc.nextDouble();
        Account account = new Account(number, holder, initialBalance, withdrawLimit);
        System.out.print("Enter amount for withdraw: ");
        account.withdraw(sc.nextDouble());

        System.out.print("New balance: " + account.getBalance());

        sc.close();
    }

}
