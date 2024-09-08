package services;

import java.util.ArrayList;
import java.util.List;

public interface OnlinePaymentService {

    public Double paymentFee(Double amount);

    public ArrayList<Double> interest(Double amount, Integer months);

}
