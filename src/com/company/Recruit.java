package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Recruit implements Cloneable {
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;

    public Recruit(String name, int damage, int lifePoints, int initiative){
        this.damage = damage;
        this.initiative = initiative;
        this.lifePoints = lifePoints;
        this.name = name;
    }

    public int getDamage(){
        return this.damage;
    }
    public String getName(){
        return this.name;
    }
    public int getLifePoints(){
        return this.lifePoints;
    }
    public int getInitiative(){
        return this.initiative;
    }

    public void takeDamage(int Damage){
        this.lifePoints -= Damage;
    }

    public Object clone() throws CloneNotSupportedException {
        return  (Recruit)super.clone();
    }

    public String toString() {
        return "Recruit {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", lifePoints=" + lifePoints +
                ", initiative=" + initiative +
                '}';
    }
}

class ListPerso {
    List<Recruit> listePerso = new ArrayList<>();

    public void addListePerso (Recruit recru){
        listePerso.add(recru);
    }

    public void displayChar(int index){
        System.out.println(listePerso.get(index - 1));
    }

    public void displayList(){
        for (int i = 0; i < listePerso.size(); i++){
            System.out.println((i + 1) + " - " + listePerso.get(i));
        }
    }

    public Recruit getRecruit (int index){
        return listePerso.get(index - 1);
    }
}

class Rogue extends Recruit implements Cloneable {
    Random random = new Random();
    int critChance;
    int dodgeChance;
    int critcount = 0;

    public Rogue(String name, int damage, int lifePoints, int initiative, int critChance, int dodgeChance) {
        super(name, damage, lifePoints, initiative);
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;
    }

    @Override
    public int getDamage() {
        int min = 0;
        int max = 100;

        int value = random.nextInt(max +min + 1) + min;

        if (value <= critChance && critcount == 0){
            critcount++;
            return this.damage*2;

        }
        else {
            critcount = 0;
            return this.damage;
        }
    }

    public void takeDamage(int Damage){
        int min = 0;
        int max = 100;

        int value = random.nextInt(max +min + 1) + min;

        if (value > dodgeChance){
            this.lifePoints -= Damage;
        }
        else{
            System.out.println(this.name + " à dodge le coup");
        }
    }
}


