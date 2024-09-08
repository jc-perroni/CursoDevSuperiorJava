package application;

import entitties.Sale;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o caminho do arquivo: ");
        String path = sc.nextLine();

        try {
            List<Sale> salesList = new ArrayList<>();
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
                salesList.add(sale);
                line = br.readLine();
            }
            List<Sale> filteredSales = salesList.stream()
                    .filter(s -> s.getYear()==2016)
                    .sorted(Comparator.comparing(Sale::averagePrice).reversed())
                    .limit(5)
                    .toList();
            filteredSales.forEach(System.out::println);

            Optional<Double> totalLogan = salesList.stream()
                    .filter(s -> s.getMonth() == 1 || s.getMonth() == 7)
                    .filter(s -> s.getSeller().equals("Logan"))
                    .map(Sale::getTotal)
                    .reduce(Double::sum);

            if(totalLogan.isPresent()){
                System.out.printf("\nValor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f", totalLogan.get());
            }
            else {
                System.out.println("Logan não teve vendas nos meses 1 e 7.");
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
