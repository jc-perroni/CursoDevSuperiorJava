package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> classes = new ArrayList<>();

        System.out.println("Quantas aulas tem o curso?");
        int classesQuantity = sc.nextInt();

        for (int i = 1; i <= classesQuantity; i++) {
            System.out.println("Dados da " + i + "a aula:");
            System.out.print("Conteúdo ou tarefa (C/T)?");
            sc.nextLine();
            char classType = sc.nextLine().toUpperCase().charAt(0);
            System.out.print("Título: ");
            String classTitle = sc.nextLine();

            if (classType == 'C') {
                System.out.print("URL do vídeo: ");
                String classUrl = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int classDuration = sc.nextInt();
                Lesson videoClass = new Video(classTitle, classUrl, classDuration);
                classes.add(videoClass);
            } else {
                System.out.print("Descrição: ");
                String classDescription = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                Lesson taskClass = new Task(classTitle, classDescription, questionCount);
                classes.add(taskClass);
            }
        }
        int totalTime = 0;
        for (Lesson x : classes){
            totalTime += x.duration();
        }
        System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalTime);
    }
}


