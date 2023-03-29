package com.example.harry;

public class Player extends Character{

    public int numAtkUpgrades, numDefUpgrades;
    public String[] atkUpgrades = {"Apprentice", "Magician","Sorceler", "Master" };
    public String[] defUpgrades = {"Negatron Cloak", "Banshee's Veil", "Abyssal Mask", "Force of Nature"};

    public Player(String name){
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        chooseTrait();
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        if (input == 1){
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "1");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();

    }
}
