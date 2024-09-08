package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                System.out.print("Enter the quantity of products to be registred:");
        int quantityProducts = sc.nextInt();
        List<Product> productList = new ArrayList<>();

        for (int i = 1; i<= quantityProducts; i++){
            System.out.printf("Product #%d data:", i);
            System.out.print("Common, used or imported (C/U/I)?");
            char productType = sc.next().toUpperCase().charAt(0);
            System.out.print("Enter the product's name:");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Now, the price: ");
            double productPrice = sc.nextDouble();

            if (productType == 'U'){
                System.out.println("Enter the manufactured date:");
                sc.nextLine();
                Product product = new UsedProduct(productName, productPrice, formatter.parse(sc.nextLine()));
                productList.add(product);
            }
            else if (productType == 'I'){
                System.out.print("Enter with the customs fee:");
                double productFee = sc.nextDouble();
                Product product = new ImportedProduct(productName,productPrice, productFee);
                productList.add(product);
            }
            else{
                Product product = new Product(productName, productPrice);
                productList.add(product);
            }
        }

        for(Product x : productList){
            System.out.println(x.priceTag());
        }
    }


}
