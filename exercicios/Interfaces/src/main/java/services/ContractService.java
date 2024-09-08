package services;

import domain.Contract;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ContractService {

    DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public OnlinePaymentService paymentService;

    public void processContract(Contract contract, Integer months){
        ArrayList<Double> listaParcelas = paymentService.interest(contract.getTotalValue(), months);
        int somaMeses = 1;
        for (Double parcela : listaParcelas){
            int meses = listaParcelas.size();
            System.out.println(dtm.format(contract.getDate().plusMonths(somaMeses))+ " - " + parcela);
            somaMeses ++;
        }

    }

}
