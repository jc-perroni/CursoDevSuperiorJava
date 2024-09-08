package entities;

import exceptions.BusinessException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer numer, String holder, Double balance, Double withdrawLimit) {
        this.number = numer;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumer() {
        return number;
    }

    public void setNumer(Integer numer) {
        this.number = numer;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double ammount){
        balance += ammount;

    }

    public void withdraw(Double ammount){
        if (ammount > balance) {
            throw new BusinessException("Saldo insuficiente");
        }
        if (ammount > withdrawLimit){
            throw new BusinessException("Retirada excede o limite.");
        }
        balance -= ammount;
    }



}
