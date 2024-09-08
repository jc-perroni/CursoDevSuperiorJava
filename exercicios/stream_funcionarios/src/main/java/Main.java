import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "/Users/julioperroni/Desktop/Cursos TI/Curso DevSuperior/CursoDevSuperior/Exercicios/stream_funcionarios/src/main/resources/funcionarios.txt";
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<Employee> employeeList = new ArrayList<>();

        String line = br.readLine();
        while(line!= null){
            String[] arrayEmployees = line.split(",");
            Employee employee = new Employee(arrayEmployees[0].strip(), arrayEmployees[1].strip(), Double.parseDouble(arrayEmployees[2].strip()));
            employeeList.add(employee);
            line = br.readLine();
        }
        System.out.println("Forneça o valor mínimo do salário a ser exibido: ");
        double minSalary = sc.nextDouble();

        List<Employee> bigSalariesList = employeeList.stream()
                        .filter(e -> e.getSalary() > minSalary)
                .sorted(Comparator.comparing(Employee::getEmail) )
                                .toList();
        Optional<Double> salariesSum = employeeList.stream()
                .filter(e -> e.getName().toUpperCase().startsWith("M"))
                        .map(Employee::getSalary)
                                .reduce(Double::sum);

        if(!bigSalariesList.isEmpty()) {
            System.out.println("E-mail dos funcionários que recebem mais que " + minSalary);
            bigSalariesList.forEach(e -> System.out.println(e.getEmail()));
        }
        else {
            System.out.println("Não há ninguém que receba acima de " + minSalary);
        }
        if(salariesSum.isPresent()){
        System.out.printf("Soma dos salários dos funcionários que tem a inicial do nome com M é %.2f", salariesSum.get());
        }
        else {
            System.out.println("Não há valores com a inicial M.");
        }
        sc.close();
    }
}
