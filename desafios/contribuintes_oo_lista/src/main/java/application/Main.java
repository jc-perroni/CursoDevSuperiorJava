package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos contribuintes você vai digitar?");
        int quantityPayers = sc.nextInt();

        List<TaxPayer> taxPayerList = new ArrayList<>();
        for (int i = 1; i <= quantityPayers; i++) {
            System.out.println("Entre com os dados do contribuinte " + i);
            System.out.println("Renda anual com salários: ");
            double salaryIncome = sc.nextDouble();
            System.out.println("Renda anual com prestação de serviços: ");
            double servicesIncome = sc.nextDouble();
            System.out.println("Entre com a renda anual com ganhos de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.println("Entre com gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.println("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome,
                    capitalIncome, healthSpending, educationSpending);
            taxPayerList.add(taxPayer);
        }
        int index =0;
        for(TaxPayer x : taxPayerList){
            System.out.printf("""
                    ______________________________________________
                    Resumo do contribuinte %d:
                    Imposto bruto total: %.2f
                    Abatimento: %.2f
                    Imposto devido: %.2f
                    
                    """, index+1, x.grossTax(), x.taxRebate(), x.netTax());
            index++;
        }

        sc.close();
    }
}
