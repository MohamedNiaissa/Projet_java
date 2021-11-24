package com.company;

import java.util.ArrayList;
import java.util.List;

public class Recruit implements Cloneable {
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

    public Object clone() throws CloneNotSupportedException {
        return  (Recruit)super.clone();
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

    public void displayList(){
        for (int i = 0; i < listePerso.size(); i++){
            System.out.println((i + 1) + " - " + listePerso.get(i));
        }
    }

    public Recruit getRecruit (int index){
        return listePerso.get(index - 1);
    }

}


