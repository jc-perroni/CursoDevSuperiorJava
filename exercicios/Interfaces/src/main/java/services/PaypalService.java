package services;

import java.util.ArrayList;
import java.util.List;

public class PaypalService implements OnlinePaymentService {


    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public ArrayList<Double> interest(Double amount, Integer months) {
        double tax = 0;
        ArrayList<Double> interestList = new ArrayList<>();
        for (int i = 1; i <= months; i++) {
            double valorFixo = amount/months;
            tax = valorFixo + valorFixo*0.01*i;
            interestList.add(tax+paymentFee(tax));
        }
        return interestList;
    }
}
