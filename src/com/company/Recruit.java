package com.company;

import java.util.ArrayList;
import java.util.List;

public class Recruit {
    private String name;
    private int damage;
    private int lifePoints;
    private int initiative;

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

    public String toString() {
        return "Recruit {" +
                "name='" + getName() + '\'' +
                ", damage=" + getDamage() +
                ", lifePoints=" + getLifePoints() +
                ", initiative=" + getInitiative() +
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

}


