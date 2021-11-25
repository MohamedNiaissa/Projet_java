package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static java.nio.file.StandardOpenOption.CREATE;

public class Recruit implements Cloneable, Fighter {
    protected String name;
    protected int damage;
    protected int initiative;
    protected int lifePoints;

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
        return  (Fighter)super.clone();
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

class Warrior implements Cloneable, Guerrier{
    protected String name;
    protected int damage;
    protected int initiative;
    protected int lifePoints;
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
            System.out.println("Blocked");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return 0;
        } else {
            System.out.println("The shield blocked " + shieldres);
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
        return  (Fighter)super.clone();
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
        return  (Fighter)super.clone();
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
            System.out.println("Critical Hit !");
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
            System.out.println(this.name + " dodged the hit");
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  (Fighter)super.clone();
    }

    public String toString() {
        return "Rogue {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", critChance=" + critChance +
                "%, lifePoints=" + lifePoints +
                ", dodgeChance=" + dodgeChance +
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
        listePerso.remove(index - 1);
    }

    public int sizeList(){
        return listePerso.size();
    }
    public void importsave(String input){

    }
    public void exportsave(String outputFile){
                /*JSONObject jsonObject = new JSONObject();
                jsonObject.put("ID", "1");
                jsonObject.put("First_Name", "Shikhar");
                jsonObject.put("Last_Name", "Dhawan");
                jsonObject.put("Date_Of_Birth", "1981-12-05");
                jsonObject.put("Place_Of_Birth", "Delhi");
                jsonObject.put("Country", "India");
                try {
                    FileWriter file = new FileWriter("E:/output.json");
                    file.write(jsonObject.toJSONString());
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("JSON file created: "+jsonObject);*/

        Path chemin = Paths.get(outputFile);
        String save = " ";
        for (int i = 0; i < listePerso.size(); i++) {
            save += listePerso.get(i) + "\n" ;
        }

        byte[] data = save.getBytes();

        OutputStream output = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(chemin, CREATE));
            output.write(data);
            output.flush();
            output.close();
            System.out.println("sauvegarde effectué");
        } catch (Exception e) {
            System.out.println("Message " + e);
        }

    }
}





