package sorcier;
import java.util.*;
import lombok.*;


@Data
public class GameLogic {

    public static boolean isRunning;

    public static String[] enemies = {"Troll", "Basilic", "Détraqueurs", "Voldemort et Peter Pettigrow", "Dolores Ombrage", "Mangemorts", "Voldemort  et Bellatrix Lestrange"};

    public static int place = 0, act = 1;
    public static String[] places = {"Toilettes du Château", "La chambre des secrets", "Lac dans la Forêt Interdite", "Cimetière de Little Hangleton", "Salle d’examen de Poudlard", "Poudlard", "Tour d'astronomie"};
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
                System.out.println("Choisissez un entier");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    public class Wait {
        public static void wait(int ms)
        {
            try
            {
                Thread.sleep(ms);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }

    //Clear console
    public static void clearConsole(){
        for (int i = 0; i < 3; i++)
            System.out.println();
    }

    //separation de longueur n
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
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
        System.out.println("\nCliquez n'importe où pour continuer...");
        scanner.next();
    }
    public static void startGame(){
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Bienvenue à Poudlard jeune apprenti");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        do{
            clearConsole();
            printHeading("Entrez votre nom");
            name = scanner.next();
            clearConsole();
            printHeading("Votre nom est "+ name + "\n Est-ce correct ?");
            System.out.println("(1) Confirmer");
            System.out.println("(2) Non, je veux changer de nom");
            int input =  readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);

        player = new Player(name);

        SortingHat.chooseHouse();

        Story.level1Intro();
        enemies[0] = "Troll";
        gameLoop();
    }

    public static void CheckAct(){
        if(player.xp >= 5 && act == 1){
            act = 2;
            place = 1;
            Story.level1Outro();
            player.chooseTrait();
            enemies[0] = "Basilic";
            player.hp = player.maxHp;
            player.potions += 1;
            System.out.println("Vous avez remmporté une potion, celle-ci vous permet de regagner tous vos PV.");

            Story.level2Intro();
            battle(new Enemy("Basilic", 10));
        }else if(player.xp >= 20 && act == 2){
            act = 3;
            place = 2;
            Story.level2Outro();
            player.chooseTrait();
            enemies[0] = "Détraqueurs";
            player.hp = player.maxHp;

            Story.level3Intro();
        }else if(player.xp >= 50 && act == 3){
            act = 4;
            place = 3;
            Story.level3Outro();
            player.chooseTrait();
            enemies[0] = "Voldemort et Peter Pettigrow";
            player.hp = player.maxHp;
            player.potions += 1;
            System.out.println("Vous avez remmporté une potion");

            Story.level4Intro();
        }else if(player.xp >= 90 && act == 4){
            act = 5;
            place = 4;
            Story.level4Outro();
            player.chooseTrait();
            enemies[0] = "Dolores Ombrage";
            player.hp = player.maxHp;

            Story.level5Intro();
        }else if(player.xp >= 140 && act == 5){
            act = 6;
            place = 7;
            Story.level5Outro();
            player.chooseTrait();
            enemies[0] = "Mangemorts";
            player.hp = player.maxHp;
            player.potions += 1;
            System.out.println("Vous avez remmporté une potion");

            Story.level6Intro();
        }else if(player.xp >= 200 && act == 6) {
            act = 7;
            place = 6;
            Story.level6Outro();
            player.chooseTrait();
            enemies[0] = "Voldemort et Bellatrix Lestrange";
            player.hp = player.maxHp;

            Story.level7Intro();

        }else if(player.xp >= 270 && act == 7) {
            act = 8;
            place = 7;
            Story.level7Outro();

        }
    }



    public static void continueJourney(){
        CheckAct();
    }

    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO : ");
        System.out.println(player.name + "\tHP : " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP : " + player.xp);
        printSeparator(20);

        System.out.println("# of Potions: " + player.potions);
        printSeparator(20);

        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive trait : " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait : " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeparator(20);
        }
    }

    public static void battle(Enemy enemy){
        while (true){
            clearConsole();
            printHeading(enemy.name + "\nHP : " + enemy.maxHp);
            printHeading(player.name + "\n HP : " + player.maxHp);
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion");
            int input = readInt("-> ", 3);
            if(input == 1){
                //FIGHT
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                if (dmgTook < 0){
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0)
                    dmg = 0;
                player.hp -= dmgTook;
                enemy.hp -= dmg;

                clearConsole();
                printHeading("BATAILLE");
                System.out.println("Vous avez infligé " + dmg + "dégâts à " + enemy.name + ".");
                printSeparator(15);
                System.out.println("Vous avez subit " + dmgTook + "dégâts de la part de " + enemy.name + ".");
                anythingToContinue();

                if (player.hp <= 0){
                   playerDied();
                   break;
                }else if(enemy.hp <= 0){
                    clearConsole();
                    printHeading("Vous avez vaincu " + enemy.name + ".");
                    player.xp += enemy.xp;
                    printSeparator(20);
                    System.out.println(" Vous avez remporté " + enemy.xp + "XP !");
                    anythingToContinue();
                    break;
                }
            }else if(input == 2){
                //USE POTION
                clearConsole();
                if (player.potions > 0 && player.hp < player.maxHp);{
                    System.out.println("Voulez-vous vraiment utiliser une potion ? Il vous  reste " + player.potions + " left.");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("-> ", 2);
                    if (input == 1) {
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("Vous avez consommé une potion, vos PV sont désormais au maximum");
                        anythingToContinue();
                    }else{
                        clearConsole();
                        printHeading("Vous n'avez pas de potion ou vos PV sont au maximum");
                        anythingToContinue();
                    }
                }
            }else{
               printHeading("Saisissez soit 1 soit 2");
               anythingToContinue();
            }

        }
    }

    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Que voulez-vous faire ? : ");
        printSeparator(20);
        System.out.println("(1) Continuer la partie");
        System.out.println("(2) Informations du personnage");
        System.out.println("(3) Exit Game");
    }

    public static void playerDied(){
        clearConsole();
        printHeading("Vous étiez un sorcier prometteur, dommage...");
        printHeading("Vous avez remporté " + player.xp + " au cours de votre aventure.");
        printHeading("Vous ferez mieux la prochaine fois !");
        isRunning = false;
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

