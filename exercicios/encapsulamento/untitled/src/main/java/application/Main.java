package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Olá. Vamos realizar o cadastro da sua conta.");
        System.out.println("Entre com seu nome: ");
        String name = sc.nextLine();
        System.out.println("Deseja colocar um deposito inicial? S/N");
        char response = sc.nextLine().toUpperCase().charAt(0);
        double initialValue = 0.00;
        if (response == 'S'){
            System.out.println("Entre com o valor do depósito inicial: ");
            initialValue += sc.nextDouble();
        }
        long accountNumber = (long) (Math.random()*10000);
        Account account = new Account(accountNumber, name, initialValue);

        account.showAccountDetails();

        System.out.println("Operação de depósito.");
        System.out.println("Entre com o valor a ser depositado: ");
        account.depositCash(sc.nextDouble());
        account.showAccountDetails();

        System.out.println("Operação de saque.");
        System.out.println("Entre com o valor a ser sacado: ");
        account.withdrawCash(sc.nextDouble());
        account.showAccountDetails();

        System.out.println("Fim");


    }

}
