package com.company;

public class Magician extends Recruit implements Cloneable{

    protected int magicDamage;

    public Magician(String name, int damage, int lifePoints, int initiative, int magicDamage) {
        super(name, damage, lifePoints, initiative);
        this.magicDamage = magicDamage;
    }


    @Override
    public int getDamage() {
        int totalDamage = super.getDamage()+magicDamage;
        magicDamage /= 2;
        return totalDamage;

    }

    public Object clone() throws CloneNotSupportedException {
        return  (Magician)super.clone();
    }

    @Override
    public String toString() {
        return "Magician {" +
            "name='" + getName() + '\'' +
                    ", damage=" + damage +
                    ", lifePoints=" + lifePoints +
                    ", initiative=" + initiative +
                    ", magicDamage=" + magicDamage +
                    '}';
    }
}
