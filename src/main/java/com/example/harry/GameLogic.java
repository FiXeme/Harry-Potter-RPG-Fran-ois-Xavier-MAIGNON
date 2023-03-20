package com.example.harry;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt, int userChoices){
        int input;

        do{
            System.out.println(prompt);
            try{
                input= Integer.parseInt(scanner, next());
            }catch(Exception e){
                input = -1;
                System.out.println("Please enter an integer");
            }
        }while(input < 1 || > userChoices);
        return input;
    }

    //Clear console
    public static void clearConsole(){
        for (int i = 0; i < 3; i++)
            System.out.println();
    }

    //separation de longueur n
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++)
            System.out.println("-");
        System.out.println();
    }

    //heading
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //stopper le jeu jusqu'à ce que l'utilisateur entre quelque chose
    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }
}
