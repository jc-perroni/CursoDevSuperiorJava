package application;

import entities.Adress;
import entities.Department;
import entities.Employee;

import javax.sound.midi.Soundbank;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o nome do departamento: ");
        String dept = sc.nextLine();
        System.out.println("Entre com o dia do pagamento: ");
        int payDay = sc.nextInt();
        sc.nextLine();
        System.out.println("Entre com o e-mail do departamento: ");
        String email = sc.nextLine();
        System.out.println("Entre com o telefone do departamento: ");
        String telefone = sc.nextLine();
        Adress adresses = new Adress(email, telefone);
        Department dpt = new Department(dept, payDay, adresses);
        System.out.println("Quantos funcionários tem no departamento?");
        int qtdFuncionarios = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtdFuncionarios; i++){
            System.out.println("Dados do funcionário " + (i+1));
            System.out.print("Nome: ");
            String name =  sc.nextLine();
            System.out.print("Salário: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            Employee employee = new Employee(name, salary);
            dpt.addEmployee(employee);
        }

        showReport(dpt);
    }
    private static void showReport(Department dept) {
        String word = dept.getEmployees().size() > 1? "Funcionários" : "Funcionário";
        System.out.printf("""
                FOLHA DE PAGAMENTO:
                Departamento %s = R$%.2f
                Pagamento realizado no dia %d
                %s:
                """, dept.getName(), dept.payroll(), dept.getPayDay(), word);
                for (Employee x : dept.getEmployees()){
                    System.out.println(x.getName());
                }
    }
}
