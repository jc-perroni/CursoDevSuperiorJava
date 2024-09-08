package application;

import entities.Individual;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of tax payers: ");
        int payers = sc.nextInt();
        for (int i = 1; payers >= i; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.println("Individual or company (I/C)?");
            sc.nextLine();
            char taxType = sc.nextLine().toUpperCase().charAt(0);
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Anual income: ");
            double anualIncome = sc.nextDouble();

            if (taxType == 'I'){
                System.out.println("Health expenditures: ");
                double healthExpeditures = sc.nextDouble();
                Individual person = new Individual(name, anualIncome, healthExpeditures);
                person.tax();
            }
            else {
                System.out.println("Number of employees: ");
                int numberEmployees = sc.nextInt();
                System.out.println("Depois faço");
            }

        }
    }
}
