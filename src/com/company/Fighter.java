package com.company;

import java.util.Collections;

public interface Fighter extends Comparable<Fighter> {
    public void setName(String name);

    public String getName();

    public void setDamage(int damage);

    public int getDamage();

    public void setLifePoints(int lifePoints);

    public int getLifePoints();

    public void setInitiative(int initiative);

    public int getInitiative();

    public void setTeam(int team);

    public int getTeam();

    public int takeDamage(int damage);

    public Object clone() throws CloneNotSupportedException;

}
interface Guerrier extends Fighter {
    public void setShieldRes(int shieldRes);

    public int getShieldRes();
}

interface Magicien extends Fighter {
    public void setMagicDamage(int magicDamage);

    public int getMagicDamage();
}

interface Voleur extends Fighter {
    public void setCritChance(int critChance);

    public int getCritChance();

    public void setDodgeChance (int dodgeChance);

    public int getDodgeChance();
}