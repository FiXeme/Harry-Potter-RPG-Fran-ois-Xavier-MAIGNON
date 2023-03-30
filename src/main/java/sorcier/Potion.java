package sorcier;

import java.util.ArrayList;
import java.util.List;

public class Potion {
    private String name;
    private int hp;

    public Potion(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public static void drinkPotion(Wizard wizard, Potion potion){
        if(wizard.getHouse() == House.Hufflepuff) {
            wizard.setHp(wizard.getHp() + potion.getHp() + 10);
            System.out.println("You have been healed by "+ (potion.getHp()+10));
        }else{
            wizard.setHp(wizard.getHp() + potion.getHp());
            System.out.println("You have been healed by "+ potion.getHp());
        }
        if (wizard.getHp() >= 100){
            wizard.setHp(100);
        }
    }

    public static List<Potion> setupPotions(){
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Common Potion", 20));
        potions.add(new Potion("Rare Potion", 40));
        potions.add(new Potion("Legendary Potion", 60));

        return potions;
    }

}
