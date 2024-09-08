import entities.Champion;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Scanner;

public class application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados do primeiro campeão: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life = sc.nextInt();
        System.out.print("Ataque: ");
        int attack = sc.nextInt();
        System.out.print("Armadura: ");
        int armor = sc.nextInt();
        sc.nextLine();
        Champion champion1 = new Champion(name, life, attack, armor);

        System.out.println("Entre com os dados do segundo campeão: ");
        System.out.print("Nome: ");
        name = sc.nextLine();
        System.out.print("Vida inicial: ");
        life = sc.nextInt();
        System.out.print("Ataque: ");
        attack = sc.nextInt();
        System.out.print("Armadura: ");
        armor = sc.nextInt();
        sc.nextLine();
        Champion champion2 = new Champion(name, life, attack, armor);

        System.out.println("Quantos turnos você deseja executar? ");
        int turns = sc.nextInt();
        for (int i = 1; i <= turns; i++){
            champion2.takeDamage(champion1.getAttack());
            champion1.takeDamage(champion2.getAttack());
            System.out.printf("""
                    ----------------------------------------------
                    Resultado do turno %d:%n%n""", i);
            System.out.println(champion1.status());
            System.out.println(champion2.status());
            if (champion1.getLife() <=0 || champion2.getLife() <=0){
                break;
            }
        }
        System.out.println("""
        ----------------------------------------------
        FIM DO COMBATE
        ----------------------------------------------""");

        sc.close();
    }

}
