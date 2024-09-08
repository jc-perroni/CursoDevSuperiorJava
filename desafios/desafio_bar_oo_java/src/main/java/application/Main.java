package application;

import entities.Bill;

import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        char gender = ' ';

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        while (gender != 'M' && gender != 'F') {
            System.out.println("Entre com o sexo do cliente (F/M): ");
            gender = sc.nextLine().toUpperCase().charAt(0);
        }
        System.out.println("Quantidade de cervejas consumidas: ");
        int beer = sc.nextInt();

        System.out.println("Quantidade de refrigerantes consumidos: ");
        int softDrink = sc.nextInt();

        System.out.println("Quantidade de espetinhos consumidos: ");
       int barbecue = sc.nextInt();

        sc.nextLine();

        double feeding = Bill.feeding(barbecue, beer, softDrink);
        double ticketValue = Bill.ticket(gender);


        System.out.printf("""
                RELATÓRIO:
                Consumo = %.2f
                Couvert = %.2f
                Ingresso = %.2f
                
                Valor a pagar = %.2f
                """,
                feeding,
                Bill.cover(feeding),
                ticketValue,
                Bill.total(feeding, ticketValue)
                );

        }


}