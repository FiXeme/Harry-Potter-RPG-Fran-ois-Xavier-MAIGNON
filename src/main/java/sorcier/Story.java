package sorcier;

import static sorcier.GameLogic.readInt;

public class Story {

    public static void level1Intro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Toilettes du Château");
        GameLogic.anythingToContinue();
        GameLogic.printSeparator(30);
        System.out.println("Votre histoire commence dans les toilettes du donjon...");
        System.out.println("Vous n'aviez pas ce programme en tête mais un troll se dresse devant vous...");
        System.out.println("Votre niveau de sorcellerie actuel ne vous permet pas de le battre dans un combat pur, il va falloir ruser");
        System.out.println("Vous devez utiliser votre environnement afin de vaincre cet ennemi");
        GameLogic.printSeparator(20);
        GameLogic.printHeading("Utilisez votre sort Wingardium Leviosa pour tuer le monstre à l'aide d'un objet");
        System.out.println("Appuyez sur 1 pour utiliser 'Wingardium Leviosa'");
        int input =  readInt("-> ", 2);
        if (input == 1){
            GameLogic.player.xp += 10;
            GameLogic.CheckAct();
        }else{
            level1IntroBis();
        }
    }

    public static void level1IntroBis(){
        GameLogic.printSeparator(20);
        GameLogic.printHeading("Utilisez votre sort Wingardium Leviosa pour tuer le monstre à l'aide d'un objet");
        System.out.println("Appuyez sur 1 pour utiliser 'Wingardium Leviosa'");
        int input =  readInt("-> ", 2);
        if (input == 1){
            GameLogic.player.xp += 10;
            GameLogic.CheckAct();
        }else{
            level1IntroBis();
        }
    }

    public static void level1Outro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Bien joué, en voilà un qui ne nous embettera plus de sitôt");
        GameLogic.anythingToContinue();
    }

    public static void level2Intro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("La chambre des secrets");
        GameLogic.anythingToContinue();
        GameLogic.printSeparator(30);
        System.out.println("Tout se passait pour le mieux pour vous à Poudlard jusqu'ici...");
        System.out.println("Vous avez cependant décidé de visiter la Chambre des secrets...");
        System.out.println("Grave erreur ! Vous voilà maintenant en face d'un nouvel ennemi à abattre, le Basilic !");
        GameLogic.anythingToContinue();
    }

    public static void level2Outro(){
        GameLogic.printSeparator(30);
        System.out.println("Ouf, ça n'était pas gagné d'avance, soyez plus prudent à l'avenir");
    }

    public static void level3Intro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Lac dans la Forêt Interdite");
        GameLogic.anythingToContinue();
        GameLogic.printSeparator(30);
        System.out.println("De nouveaux ennemis cherchent à vous nuire.");
        System.out.println("Utilisez votre nouveau sort pour les faire fuir !");
        GameLogic.anythingToContinue();
    }

    public static void level3Outro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Bien joué, ils ont pris la fuite.");
    }

    public static void level4Intro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Cimetière de Little Hangleton");
        GameLogic.anythingToContinue();
        GameLogic.printSeparator(30);
        System.out.println("Voldemortet & Peter Pettigrow vous menacent");
        System.out.println("Pas le choix, il faut fuir");
        GameLogic.anythingToContinue();
    }

    public static void level4Outro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Sain et sauf !");
    }

    public static void level5Intro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Salle d’examen de Poudlard");
        GameLogic.anythingToContinue();
        GameLogic.printSeparator(30);
        System.out.println("Combattez Dolores Ombrage jusqu'à obtenir les feux d'artifice");
        GameLogic.anythingToContinue();
    }

    public static void level5Outro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Bravo, quel spectacle !");
    }

    public static void level6Intro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Tour d'astronomie");
        GameLogic.anythingToContinue();
        GameLogic.printSeparator(30);
        System.out.println("Les Mangemorts attaquent Poudlard, repoussez-les jusqu'au dernier !");
        GameLogic.anythingToContinue();
    }

    public static void level6Outro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Les Mangemorts sont vaincus !");
        System.out.println("Vous avez sauvé Poudlard");
    }

    public static void level7Intro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Poudlard");
        GameLogic.anythingToContinue();
        GameLogic.printSeparator(30);
        System.out.println("Vous arrivez à la fin de vos études à Poudlard...");
        System.out.println("Votre dernière épreuve sera sans doute la plus dure : vaincre Voldemort et Belatrix Lestrange");
        GameLogic.anythingToContinue();
    }

    public static void level7Outro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("La lutte finale est enfin terminée");
        System.out.println("Voldemort vaincu, vous avez gagné");
        GameLogic.anythingToContinue();
    }

}
