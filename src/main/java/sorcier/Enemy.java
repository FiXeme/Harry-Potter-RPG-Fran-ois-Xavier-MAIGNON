package sorcier;

import spell.spell;
import spell.forbiddenSpell;
import lombok.*;

public class Enemy extends AbstractEnemy {

    public Enemy(String name, int maxHp, int atk, int def) {
        super(name, maxHp, atk, def);

    }



    @Override
    public int attack(spell spell, Character character) {
        /*int damage = spell.getDamage() * (enemy.getAtk() - character.getDef())  * 1/100;
        System.out.println(enemy.getName()+" Attacked you with "+spell.getName()+" and dealt you "+damage);*/
        return 0;
    }

    @Override
    public int attack1(Character character) {
        int damage = getAtk() - character.getDef()/5;
        if (damage <= 0){
            damage = 0;
        }
        System.out.println("The " + getName() + "dealt you "+damage+" damage");
        return damage;
    }

    @Override
    public int attack(Character character, spell spell) {
        return 0;
    }

    @Override
    public int attack2(forbiddenSpell forbiddenSpell, Character character) {
        return 0;
    }

    @Override
    public void takeDamage(int damage){

        setHp(getHp()-damage);
        if (getHp() <= 0){
            setHp(0);
        }
    }

}
