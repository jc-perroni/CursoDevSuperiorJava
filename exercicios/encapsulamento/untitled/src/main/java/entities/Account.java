package entities;

public class Account {

    private final long accountNumber;
    private String name;
    private double totalAccountCash;

    public Account(long accountNumber, String name){
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public Account(long accountNumber, String name, double initialValue){
        this.accountNumber = accountNumber;
        this.name = name;
        this.totalAccountCash = initialValue;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAccountCash(){
        return totalAccountCash;
    }

    public void depositCash(double cash){
        this.totalAccountCash += cash;
        System.out.printf("$%.2f deposited to the account succesfully. Now, you" +
                " have %.2f. ", cash, this.totalAccountCash);
    }

    public void withdrawCash(double cash){
        this.totalAccountCash -= cash;
        this.totalAccountCash -= 5.00;
        System.out.printf("$%.2f withdrawed from the account succesfully. Now, you" +
                " have %.2f. ", cash, this.totalAccountCash);
    }

    public void showAccountDetails(){
        System.out.printf("""
                -------------------------------------------------------
                Account Number: %d
                Account Name: %s
                Balance: %.2f
                -------------------------------------------------------
                """, this.accountNumber, this.name, this.totalAccountCash);
    }

}
