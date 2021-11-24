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

    public int takeDamage(int Damage){
        this.lifePoints -= Damage;
        return Damage;
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
class Warrior extends Recruit implements Cloneable{
    protected int shieldres;

    public Warrior(String name, int damage, int lifePoints, int initiative, int shield) {
        super(name, damage, lifePoints, initiative);
        this.shieldres = shield;
    }
    public int takeDamage(int damage){
        if (damage-shieldres<=0){
            System.out.println("Bloqué");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return 0;
        } else {
            System.out.println("Le bouclier bloque " + shieldres);
            lifePoints -= damage-shieldres;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return damage-shieldres;
        }
    }
    public String toString() {
        return "Warrior {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", lifePoints=" + lifePoints +
                ", shieldResistance=" + shieldres +
                ", initiative=" + initiative +
                '}';
    }

}
class Magician extends Recruit implements Cloneable{

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




    @Override
    public String toString() {
        return "Magician {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", lifePoints=" + lifePoints +
                ", initiative=" + initiative +
                ", magicDamage=" + magicDamage +
                '}';
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
            System.out.println("Coup critique !");
            return this.damage*2;
        }
        else {
            critcount = 0;
            return this.damage;
        }
    }

    public int takeDamage(int Damage){
        int min = 0;
        int max = 100;

        int value = random.nextInt(max +min + 1) + min;

        if (value > dodgeChance){
            this.lifePoints -= Damage;
            return Damage;
        }
        else{
            System.out.println(this.name + " à dodge le coup");
            return 0;
        }
    }
    public String toString() {
        return "Rogue {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", lifePoints=" + lifePoints +
                ", dodgeChance=" + dodgeChance +
                "%, critChance=" + critChance +
                "%, initiative=" + initiative +
                '}';
    }
}





