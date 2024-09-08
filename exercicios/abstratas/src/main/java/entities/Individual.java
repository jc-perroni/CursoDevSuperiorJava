package entities;

public class Individual extends TaxPayer{

    private Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Individual(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double discount = 0;
        if (this.healthExpenditures != null) {
        discount = healthExpenditures*0.5;
        }

        if (getAnualIncome() < 20000){
            System.out.println(getAnualIncome()*0.85+discount);
            return  getAnualIncome();
        }
        else
            System.out.println(getAnualIncome()*0.75+discount);
            return getAnualIncome();
    }
}
