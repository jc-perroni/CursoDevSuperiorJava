import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data1 = LocalDate.now();


        System.out.println("Enter client data:");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("E-mail:");
        String email = sc.nextLine();
        System.out.println("Birth Date (DD/MM/YYYY): ");
        String stringBirthDate = sc.nextLine();
        LocalDate birthdate = LocalDate.parse(stringBirthDate, formatDate);
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String statusOrderSt = sc.nextLine();
        OrderStatus statusOrder = OrderStatus.valueOf(statusOrderSt);
        System.out.println("How many items to this order?");
        int itemsQuantity = sc.nextInt();
        sc.nextLine();

        Order clientOrder = new Order(statusOrder);

        for (int i = 0; i < itemsQuantity; i++){
            System.out.printf("Enter #%d item data: %n", i+1);
            System.out.println("Product name: ");
            String productName = sc.nextLine();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            Product product = new Product(productName, productPrice);
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            clientOrder.addItem(orderItem);
        }

        System.out.println("ORDER SUMARY:");
        System.out.printf("Order moment: %s ", data1);
        System.out.printf("Order Status: %s", clientOrder.getStatus());
        System.out.printf("%nClient: %s (%s) - %s%n", name, birthdate, email);
        System.out.println("Order items:");
        for (OrderItem x : clientOrder.getOrdensItems()){
            System.out.println(x);
        }


    }

}