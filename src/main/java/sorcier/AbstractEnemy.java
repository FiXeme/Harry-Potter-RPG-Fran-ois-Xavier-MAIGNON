package sorcier;

import spell.harry.spell;
import sorcier.Character;

public abstract class AbstractEnemy extends Character {
    public AbstractEnemy(String name, int maxHp, int atk, int def) {
        super(name, 100, 0);
    }

    public abstract int attack1(Character character);

    public abstract int attack(Character character, spell spell);
}
