package application;

import entities.Cursos;
import entities.Students;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Set<Students> studentSet = new HashSet<>();

        System.out.println("How many students for course A?");
        int studentsQtd = sc.nextInt();
        for (int i = 1; studentsQtd >= i; i++){
            System.out.println("Próximo:");
            Students student = new Students(sc.nextInt(),Cursos.A.toString());
            studentSet.add(student);
        }

        System.out.println("How many students for course B?");
        studentsQtd = sc.nextInt();
        for (int i = 1; studentsQtd >= i; i++){
            System.out.println("Próximo:");
            Students student = new Students(sc.nextInt(),Cursos.B.toString());
            studentSet.add(student);
        }

        System.out.println("How many students for course C?");
        studentsQtd = sc.nextInt();
        for (int i = 1; studentsQtd>= i; i++){
            System.out.println("Próximo:");
            Students student = new Students(sc.nextInt(),Cursos.C.toString());
            studentSet.add(student);
        }

        System.out.println(studentSet.size());

        sc.close();
    }

}
