package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Recruit implements Cloneable, Fighter {
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

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLifePoints(){
        return this.lifePoints;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative;
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
    List<Fighter> listePerso = new ArrayList<>();

    public void addListePerso (Fighter recru){
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

    public Fighter getRecruit (int index){
        return listePerso.get(index - 1);
    }

    public void removeList(int index){
        listePerso.remove(index);
    }
}

class Warrior implements Cloneable, Guerrier {
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;
    protected int shieldres;

    public Warrior(String name, int damage, int lifePoints, int initiative, int shield) {
        this.name = name;
        this.damage = damage;
        this.lifePoints = lifePoints;
        this.initiative = initiative;
        this.shieldres = shield;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @Override
    public int getInitiative() {
        return this.initiative;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
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

    @Override
    public void setShieldRes(int shieldRes) {
        this.shieldres = shieldRes;
    }

    @Override
    public int getShieldRes() {
        return this.shieldres;
    }
}
class Magician implements Cloneable, Magicien {
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;
    protected int magicDamage;

    public Magician(String name, int damage, int lifePoints, int initiative, int magicDamage) {
        this.name = name;
        this.damage = damage;
        this.lifePoints = lifePoints;
        this.initiative = initiative;
        this.magicDamage = magicDamage;
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        int totalDamage = damage + magicDamage;
        magicDamage /= 2;
        return totalDamage;
    }

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @Override
    public int getInitiative() {
        return this.initiative;
    }

    @Override
    public int takeDamage(int Damage){
        this.lifePoints -= Damage;
        return Damage;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
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

    @Override
    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    @Override
    public int getMagicDamage() {
        return this.magicDamage;
    }
}

class Rogue implements Cloneable, Voleur {
    Random random = new Random();
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;
    int critChance;
    int dodgeChance;
    int critcount = 0;

    public Rogue(String name, int damage, int lifePoints, int initiative, int critChance, int dodgeChance) {
        this.name = name;
        this.damage = damage;
        this.lifePoints = lifePoints;
        this.initiative = initiative;
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
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

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @Override
    public int getInitiative() {
        return this.initiative;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
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

    @Override
    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    @Override
    public int getCritChance() {
        return this.critChance;
    }

    @Override
    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    @Override
    public int getDodgeChance() {
        return this.dodgeChance;
    }
}





