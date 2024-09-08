package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Map<Candidato, Integer> votacao = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/julioperroni/Desktop/Cursos TI/Curso DevSuperior/CursoDevSuperior/Exercicios/eleicoes/src/main/resources/eleicoes.txt"));
            String line = br.readLine();
            System.out.println("Votos registrados nas urnas apuradas:");
            while (line!=null){
                System.out.println(line);
                String[] voto = line.split(",");
                String votoNome = voto[0];
                int votoQtd = Integer.parseInt(voto[1]);
                Candidato candidatoTemp = new Candidato(votoNome, votoQtd);
                if (votacao.containsKey(candidatoTemp)){
                    votacao.compute(candidatoTemp, (k, votesSoFar) -> votoQtd + votesSoFar);
                    System.out.printf("Mais %d votos para o candidato %s.", votoQtd, votoNome);
                    }
                else{
                    System.out.println("Esse é novo na parada.");
                    votacao.put(candidatoTemp, votoQtd);
                }
                line = br.readLine();
            }
            System.out.println("\nTotal de votos por candidato:");
            for (Map.Entry<Candidato, Integer> entry : votacao.entrySet()){
                Candidato candidato = entry.getKey();
                int votos = entry.getValue();
                System.out.println("Candidato " + candidato.getCandidato());
                System.out.println("Votos " + votos);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Exceção não prevista." + e);
        }
        finally {
            sc.close();

        }

    }

}
