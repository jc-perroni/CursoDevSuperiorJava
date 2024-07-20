package entities;

public class TaxPayer {

private final double  salaryIncome;
private final double servicesIncome;
private final double capitalIncome;
private final double healthSpending;
private final double educationSpending;
private final double totalIncome;
private final double totalSpendings;

    public double getTotalIncome() {
        return totalIncome;
    }

    public TaxPayer(double salaryIncome, double servicesIncome,
                    double capitalIncome, double healthSpending,
                    double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
        this.totalIncome = this.salaryIncome+this.servicesIncome+this.capitalIncome;
        this.totalSpendings = this.healthSpending + this.educationSpending;
    }

    public double salaryTax(){
    if (this.salaryIncome/12 < 3000.00) {
        return 0;
    }
    else {
        return this.salaryIncome/12 < 5000.00 ? 10.00 : 20.00;
    }
}
public double servicesTax(){
        return this.servicesIncome > 0 ?  15.00 : 0.00;
}
public double capitalTax(){
    return this.capitalIncome > 0 ? 20.00 : 0.00;
}
public double grossTax(){
    return ((salaryTax()/100*salaryIncome
            + servicesTax()/100*servicesIncome
            + capitalTax()/100*capitalIncome));

}
public double taxRebate(){
        return this.totalSpendings > 0.3*grossTax() ? 0.3*grossTax():this.totalSpendings;
}
public double netTax(){
    return grossTax()-taxRebate();
}
}

