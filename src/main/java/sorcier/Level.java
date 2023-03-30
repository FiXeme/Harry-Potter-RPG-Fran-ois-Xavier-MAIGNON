package sorcier;

import static sorcier.GameLogic.*;

public class Level {

    public static void level1(){
        /* Level 1 */

        gameLoop();
        Story.level1Intro();
        Enemy troll;
        troll = new Enemy("Troll", 100, 40, 200);
        anythingToContinue();
        System.out.println("You are getting ready to fight the "+troll.getName());
        anythingToContinue();
        battle1(troll);
        Story.level1Outro();
        healWizard(wizard);
        chooseUpgrade(wizard);
    }

    public static void level2(){
        /* Level 2 */

        addPotion(Potion.setupPotions().get(1));
        place = 1;
        gameLoop();
        learnSpell(setupSpells().get(3));
        anythingToContinue();
        Story.level2Intro();
        Enemy basilisk;
        basilisk = new Enemy("Basilisk",1000,30,300);
        System.out.println("You are getting ready to fight the "+basilisk.getName());
        battle2(basilisk);
        Story.level2Outro();
        anythingToContinue();
        healWizard(wizard);
        chooseUpgrade(wizard);
    }

    public static void level3(){
        /* Level 3 */

        place = 2;
        gameLoop();
        learnSpell(setupSpells().get(4));
        anythingToContinue();
        Story.level3Intro();
        Enemy dementor;
        dementor = new Enemy("Dementor", 100, 40,50);
        System.out.println("You are getting ready to fight an army of "+dementor.getName());
        battle3(dementor);
        Story.level3Outro();
        anythingToContinue();
        healWizard(wizard);
    }

    public static void level4(){
        /* Level 4 */

        addPotion(Potion.setupPotions().get(1));
        place = 3;
        chooseUpgrade(wizard);
        learnSpell(setupSpells().get(2));
        gameLoop();
        Story.level4Intro();
        Boss voldemort;
        voldemort = new Boss("Voldemort", 500, 100, 100, setupForbiddenSpells(), null);
        Boss peter_pettigrew;
        peter_pettigrew = new Boss("Peter Pettigrew", 100, 40, 30, setupForbiddenSpells(), null);
        tutoDefend();
        System.out.println("You are getting ready to fight Voldemort and Peter Pettigrew. Keep in mind that your spell accio has as range 50m");
        System.out.println("Not sure you are strong enough to beat them... maybe you should try to run out");
        battle4(voldemort, peter_pettigrew);
        Story.level4Outro();
        anythingToContinue();
        healWizard(wizard);
    }

    public static void level5(){
        /* Level 5 */

        addPotion(Potion.setupPotions().get(2));
        place = 4;
        chooseUpgrade(wizard);
        learnSpell(setupSpells().get(5));
        gameLoop();
        Story.level5Intro();
        level5spellsKnown();
        Boss ombrage;
        ombrage = new Boss("Dolores Ombrage", 600, 60, 60, null, level5spellsKnown());
        System.out.println("You will have to fight against Dolores Ombrage waiting for the other students to prepare fireworks");
        anythingToContinue();
        System.out.println("You are getting ready to fight Dolores Ombrage");
        anythingToContinue();
        battle5(ombrage);
        Story.level5Outro();
        anythingToContinue();
        healWizard(wizard);
    }

    public static void level6(){
        /* Level 6 */

        addPotion(Potion.setupPotions().get(2));
        place = 5;
        chooseUpgrade(wizard);
        learnSpell(setupSpells().get(6));
        gameLoop();
        Story.level6Intro();

        Boss deathEater1;
        Boss deathEater2;
        Boss deathEater3;
        deathEater1 = new Boss("DeathEater1", 200,80,60, setupForbiddenSpells(), null);
        deathEater2 = new Boss("DeathEater2", 200, 80, 60, setupForbiddenSpells(), null);
        deathEater3 = new Boss("DeathEater3", 200, 80, 60, setupForbiddenSpells(), null);
        System.out.println("You will fight 3 DeathEaters");
        anythingToContinue();
        battle6(deathEater1, deathEater2, deathEater3);
        Story.level6Outro();
        anythingToContinue();
        healWizard(wizard);

    }

    public static void level7(){
        /* Level 7 */

        addPotion(Potion.setupPotions().get(2));
        place = 6;
        chooseUpgrade(wizard);
        gameLoop();
        Story.level7Intro();

        Boss voldemort;
        voldemort = new Boss("Voldemort", 500, 100, 100, setupForbiddenSpells(), null);
        Boss belatrix;
        belatrix = new Boss("Belatrix Lestrange", 400, 80, 80, setupForbiddenSpells(),null);
        System.out.println("You are getting ready to fight Voldemort and Belatrix Lestrange");
        anythingToContinue();
        battle7(voldemort, belatrix);
        anythingToContinue();
        Story.level7Outro();

    }



}
