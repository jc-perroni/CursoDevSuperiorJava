package application;

import domain.Contract;
import services.ContractService;
import services.PaypalService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Número:" );
        int contractNumber  = sc.nextInt();
        LocalDate contractDate = LocalDate.now();
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();
        System.out.print("Entre com o número de parcelas do contrato: ");
        int contractInstallments = sc.nextInt();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);
        ContractService paymentType = new ContractService(new PaypalService());
        paymentType.processContract(contract, contractInstallments);

        sc.close();
    }

}
