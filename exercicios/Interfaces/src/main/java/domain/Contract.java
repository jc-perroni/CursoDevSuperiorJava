package domain;

import services.ContractService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Contract {

    private Integer contractNumber;
    private LocalDate date;
    private Double totalValue;
    private List<Installment> installments;

    public Contract(Integer contractNumber, LocalDate date, Double totalValue) {
        this.contractNumber = contractNumber;
        this.date = date;
        this.totalValue = totalValue;

    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void addInstallments(Installment installment){
        this.installments.add(installment);
    }
}
