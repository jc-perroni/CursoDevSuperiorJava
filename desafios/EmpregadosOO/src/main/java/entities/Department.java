package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private int payDay;
    private List<Employee> employees = new ArrayList<>();
    private Adress adress;

    public Department(String name, int payDay, Adress adress) {
        this.name = name;
        this.payDay = payDay;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayDay() {
        return payDay;
    }

    public void setPayDay(int payDay) {
        this.payDay = payDay;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public  double payroll() {
        double salarySum = 0;
        for(Employee x : employees) {
           salarySum += x.getSalary();
        }
        return salarySum;
    }
}
