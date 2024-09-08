import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/julioperroni/Desktop/Cursos TI/Curso DevSuperior/CursoDevSuperior/Exercicios/exercicioStream/src/main/resources/listaProdutos.csv"));
            String line = br.readLine();
            while (line != null){
                String[] productSplitted = line.split(";");
                System.out.println("Nome produto adicionado: " + productSplitted[0]);
                System.out.println("Preço produto adicionado: " + productSplitted[1]);
                Product product = new Product(productSplitted[0], Double.parseDouble(productSplitted[1].replaceAll("[^\\d.]", "")));
                productList.add(product);
                line = br.readLine();
            }
                double avarege =  productList.stream()
                        .map(Product::getPrice)
                        .reduce(0.00, Double::sum)/productList.size();
                System.out.println("A média é igual a " + avarege);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        sc.close();
    }



}
