package com.example.harry;
import java.util.*;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static int readInt(String prompt, int userChoices){
        int input;

        do{
            System.out.println(prompt);
            try{
                input= Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Please enter an integer");
            }
        }while(input < 1 || input > userChoices);
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
    public static void startGame(){
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Welcome to Poudlard young apprentice");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        do{
            clearConsole();
            printHeading("Enter your name");
            name = scanner.next();
            clearConsole();
            printHeading("Your name is "+ name + "\n Is that correct ?");
            System.out.println("(1) Confirm");
            System.out.println("(2) No, I want to change my name");
            int input =  readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);

        player = new Player(name);
        gameLoop();
    }

    public static void continueJourney(){

    }

    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO : ");
        System.out.println(player.name + "\tHP : " + player.hp + "/" + player.maxHp);
    }

    public static void printMenu(){
        clearConsole();
        printHeading("MENU");
        System.out.println("Choose an action : ");
        printSeparator(20);
        System.out.println("(1) Continue on your Journey");
        System.out.println("(2) Character info");
        System.out.println("(3) Exit Game");
    }
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if(input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}
