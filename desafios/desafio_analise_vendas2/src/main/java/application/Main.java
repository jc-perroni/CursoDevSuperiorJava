package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import entitties.Sale;
import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o caminho do arquivo: ");
        String path = sc.nextLine();

        try {
            Set<Sale> uniqueNames = new LinkedHashSet<>();
            List<Sale> totalSalesList = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while(line != null){
                String[] splitedList = line.split(",");
                Sale sale = new Sale(
                        Integer.valueOf(splitedList[0]),
                        Integer.valueOf(splitedList[1]),
                        splitedList[2],
                        Integer.valueOf(splitedList[3]),
                        Double.valueOf(splitedList[4]));
                uniqueNames.add(sale);
                totalSalesList.add(sale);
                line = br.readLine();
            }
            System.out.println("Total de vendas por vendedor:");
            for(Sale sale : uniqueNames){
                double totalSale = totalSalesList.stream()
                        .filter(s -> s.getSeller().equals(sale.getSeller()))
                        .map(s -> s.getTotal())
                        .reduce(0.00, Double::sum);
                System.out.printf(sale.getSeller() + " - R$ %.2f\n", totalSale);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}
