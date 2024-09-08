package entities;

public class Bill {

    public static double cover(double feeding) {
        return feeding < 30.00 ? 4.00 : 0.00;
    }

    public static double feeding(int barbecue, int beer, int softDrink) {
        return barbecue * 7.00 + beer * 5.00 + softDrink * 3.00;
    }

    public static double ticket(char gender) {
        return gender == 'M' ? 10.00 : 8.00;
    }

    public static double total(double feeding, double ticket) {
        return feeding + ticket + cover(feeding);
    }
}

