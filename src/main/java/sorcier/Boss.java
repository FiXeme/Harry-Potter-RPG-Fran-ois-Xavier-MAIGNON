package sorcier;

import Spell.spell;
import Spell.forbiddenSpell;

import java.util.List;

import static sorcier.GameLogic.boss;
import static sorcier.Character;

public class Boss extends AbstractEnemy {
    private static List spellsKnown;
    private static List authorizedSpellsKnown;
    public Boss(String name, int maxHp, int atk, int def, List spellsKnown, List authorizedSpellsKnown) {
        super(name, maxHp, atk, def);
        this.spellsKnown = spellsKnown;
        this.authorizedSpellsKnown = authorizedSpellsKnown;
    }

    public List<forbiddenSpell> getSpellsKnown() {
        return spellsKnown;
    }

    public void setSpellsKnown(List<forbiddenSpell> knownSpells) {
        this.spellsKnown = knownSpells;
    }

    public List<spell> getAuthorizedSpellsKnown() {
        return authorizedSpellsKnown;
    }

    public void setAuthorizedSpellsKnown(List<spell> authorizedSpellsKnown) {
        this.authorizedSpellsKnown = authorizedSpellsKnown;
    }

    @Override
    public int attack1(Character character) {
        return 0;
    }

    @Override
    public int attack2(forbiddenSpell forbiddenSpell, Character character) {
        int damage = forbiddenSpell.getDamage() * (getAtk() - character.getDef())  * 1/100;
        if (damage <= 0){
            damage = 0;
        }
        System.out.println(getName()+" Attacked you with "+forbiddenSpell.getName()+" and dealt you "+damage);
        if (!sorcier.defend()){
            System.out.println("You took the damage");
        } else{
            System.out.println("You have used Protego! You don't receive any damage.");
            damage = 0;
        }
        return damage;
    }

    @Override
    public int attack(Character character, spell spell){
        int damage = spell.getDamage() * (getAtk() - character.getDef()/2)  * 1/100;
        if (damage <= 0){
            damage = 0;
        }
        System.out.println(getName()+" Attacked you with "+spell.getName()+" and dealt you "+damage);
        if (!sorcier.defend()){
            System.out.println("You took the damage");
        } else{
            System.out.println("You have used Protego! You don't receive any damage.");
            damage = 0;
        }
        return damage;
    }

    public void takeDamage(int damage){
        setHp(getHp()-damage);
        if (getHp() <= 0){
            setHp(0);
        }

    }




}