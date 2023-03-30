package sorcier;

import java.util.ArrayList;
import java.util.Random;
public class SortingHat {
    public static void chooseHouse() {
        System.out.println("Voici le Choipeau, c'est lui qui va décider de ta maison. ");
        GameLogic.Wait.wait(2000);
        ArrayList<String> houses = new ArrayList<>();
        houses.add("Gryffondor ");
        houses.add("Serdaigle ");
        houses.add("Poufsouffle ");
        houses.add("Serpentard ");
        Random rand = new Random();
        int ChoosedHouse = rand.nextInt(houses.size());
        String house = houses.get(ChoosedHouse);
        System.out.println("Mmmmh laisse moi réfléchir ....... Hmmmh oui cela me semble évident ........ Aucun doute, ta maison sera : " + house);
    }
}
