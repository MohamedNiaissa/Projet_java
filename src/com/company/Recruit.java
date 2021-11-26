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
    protected int team;

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

    @Override
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
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

    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}

class Warrior implements Cloneable, Guerrier{
    protected String name;
    protected int damage;
    protected int initiative;
    protected int lifePoints;
    protected int shieldres;
    protected int team;

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
        System.out.println(name + " use is axe");
        System.out.println("<n>\n" +
                " O  /\\\n" +
                " |-/\\/\n" +
                "/| \n" +
                "/ \\");
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
    @Override
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
    }

    public int takeDamage(int damage){
        if (damage-shieldres<=0){
            System.out.println("Blocked");
            System.out.println("<n>\n" +
                    " O ___\n" +
                    " |-| |\n" +
                    "/| \\_/\n" +
                    "/ \\");
            return 0;
        } else {
            System.out.println("The shield blocked " + shieldres);
            lifePoints -= damage-shieldres;
            System.out.println("<n>\n" +
                    " O ___\n" +
                    " |-| |\n" +
                    "/| \\_/\n" +
                    "/ \\");
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
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}
class Magician implements Cloneable, Magicien {
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;
    protected int magicDamage;
    protected int team;

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
        if (magicDamage > 0){
            System.out.println(name + " use a magic bolt");
            System.out.println("_n_\n" +
                    " O  O  -/\\\n" +
                    " |-/   -\\/\n" +
                    "/|\n" +
                    "/ \\");
        }else{
            System.out.println(name + " use is staff");
            System.out.println("_n_\n" +
                    " O  O\n" +
                    " |-/\n" +
                    "/| \n" +
                    "/ \\");
        }
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
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
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
                ", magicDamage=" + magicDamage +
                ", lifePoints=" + lifePoints +
                ", initiative=" + initiative +
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
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}

class Rogue implements Cloneable, Voleur {
    Random random = new Random();
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;
    protected int team;
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
            System.out.println(" n\n" +
                    "/O\\,/!\n" +
                    " |_/`:\n" +
                    "/|   :\n" +
                    "/ \\ _¡_");
            return this.damage*2;
        }
        else {
            System.out.println(name + " use his knife");
            System.out.println(" n\n" +
                    "/O\\,/\n" +
                    " |_/`\n" +
                    "/|\n" +
                    "/ \\");
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

    @Override
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
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
            System.out.println(" n--\n" +
                    "/O\\--\n" +
                    "_|/--\n" +
                    " |--\n" +
                    "/ \\--");
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
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}
class GuerrierVoleur implements Cloneable,Guerrier,Voleur{
    protected String name;
    protected int damage;
    protected int initiative;
    protected int lifePoints;
    protected int shieldres;
    protected int dodgeChance;
    protected int critChance;
    protected int team;
    int critcount = 0;
    Random random = new Random();

    public int getShieldRes() {
        return this.shieldres;
    }

    public void setShieldRes(int shieldRes) {
        this.shieldres = shieldRes;
    }

    public GuerrierVoleur(String name, int damage, int lifePoints, int initiative, int critChance, int dodgeChance,int shieldres) {
        this.name = name;
        this.damage = damage;
        this.lifePoints = lifePoints;
        this.initiative = initiative;
        this.shieldres = shieldres;
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
            System.out.println("<n>  /!\n" +
                    "/O\\,/ :\n" +
                    " |_/` :\n" +
                    "/|    :\n" +
                    "/ \\  _¡_");
            return this.damage*2;
        }
        else {
            System.out.println(name + " use his blade");
            System.out.println("<n>  /\n" +
                    "/O\\,/\n" +
                    " |_/`\n" +
                    "/|   \n" +
                    "/ \\");
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

    @Override
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
    }

    public int takeDamage(int Damage){
        int min = 0;
        int max = 100;

        int value = random.nextInt(max +min + 1) + min;

        if (value > dodgeChance){
            if (damage-shieldres<=0){
                System.out.println("<n>\n" +
                        "/O\\___\n" +
                        " |_| |\n" +
                        "/| \\_/\n" +
                        "/ \\");
                System.out.println("Blocked");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                return 0;
            } else {
                System.out.println("The shield blocked " + shieldres);
                lifePoints -= damage - shieldres;
                System.out.println("<n>\n" +
                        "/O\\___\n" +
                        " |_| |\n" +
                        "/| \\_/\n" +
                        "/ \\");
                return damage - shieldres;
            }
        }
        else{
            System.out.println(this.name + " dodged the hit");
            System.out.println("<n>--\n" +
                    "/O\\--\n" +
                    "_|/--\n" +
                    " |--\n" +
                    "/ \\--");
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  (Fighter)super.clone();
    }

    public String toString() {
        return "RogueWarrior {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", critChance=" + critChance +
                "%, lifePoints=" + lifePoints +
                ", shieldResistance=" + shieldres +
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
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}
class MageGuerrier implements Cloneable,Magicien,Guerrier{
    protected String name;
    protected int damage;
    protected int initiative;
    protected int lifePoints;
    protected int shieldres;
    protected int magicDamage;
    protected int team;
    @Override
    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    @Override
    public int getMagicDamage() {
        return this.magicDamage;
    }
    public MageGuerrier(String name, int damage, int lifePoints, int initiative, int shield, int magicDamage) {
        this.name = name;
        this.damage = damage;
        this.lifePoints = lifePoints;
        this.initiative = initiative;
        this.shieldres = shield;
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
        if (magicDamage>0) {
            System.out.println(name + " utilise son épée magique");
            System.out.println("      _\n" +
                    "_n_  //|\n" +
                    "<n> ///\n" +
                    " O \\//\n" +
                    " |_/\\\n" +
                    "/| \n" +
                    "/ \\");
        }else{
            System.out.println(name + " utilise son épée");
            System.out.println("_n_   /\n" +
                    "<n>  /\n" +
                    " O \\/\n" +
                    " |_/\\\n" +
                    "/| \n" +
                    "/ \\");
        }
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
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
    }

    public int takeDamage(int damage){
        if (damage-shieldres<=0){
            System.out.println("Blocked");
            System.out.println("_n_\n" +
                    "<n>\n" +
                    " O ___\n" +
                    " |_| |\n" +
                    "/| \\_/\n" +
                    "/ \\");
            return 0;
        } else {
            System.out.println("The shield blocked " + shieldres);
            lifePoints -= damage-shieldres;
            System.out.println("_n_\n" +
                    "<n>\n" +
                    " O ___\n" +
                    " |_| |\n" +
                    "/| \\_/\n" +
                    "/ \\");
            return damage-shieldres;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  (Fighter)super.clone();
    }

    public String toString() {
        return "MagicWarrior {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", magicDamage=" + magicDamage +
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
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}
class MageVoleur implements Cloneable,Magicien,Voleur {
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;
    protected int magicDamage;
    protected int team;
    int critChance;
    int dodgeChance;
    int critcount = 0;
    Random random = new Random();

    public MageVoleur(String name, int damage, int lifePoints, int initiative, int magicDamage, int critChance, int dodgeChance) {
        this.name = name;
        this.damage = damage;
        this.lifePoints = lifePoints;
        this.initiative = initiative;
        this.magicDamage = magicDamage;
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
        int totalDamage = damage + magicDamage;
        magicDamage /= 2;
        int value = random.nextInt(max +min + 1) + min;

        if (value <= critChance && critcount == 0){
            critcount++;
            System.out.println("Critical hit !");
            if (magicDamage > 0){
                System.out.println(name + " use a magic stinger");
                System.out.println("_n_\n" +
                        " O ,O --->\n" +
                        " |-/`\n" +
                        "/|\n" +
                        "/ \\");
            }else{
                System.out.println(name + " use the hidden knife of his staff");
                System.out.println("_n_\n" +
                        "/O\\,/!\n" +
                        " |_/':\n" +
                        "/|   :\n" +
                        "/ \\ _!_");
            }
            return totalDamage*2;
        }
        else {
            if (magicDamage > 0){
                System.out.println(name + " use a magic bolt");
                System.out.println("_n_\n" +
                        "/O\\ O  -/\\\n" +
                        " |-/   -\\/\n" +
                        "/|\n" +
                        "/ \\");
            }else{
                System.out.println(name + " use the hidden knife of his staff");
                System.out.println("_n_\n" +
                        "/O\\,/\n" +
                        " |-/'\n" +
                        "/| \n" +
                        "/ \\");
            }
            critcount = 0;
            return totalDamage;
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

    @Override
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
    }

    @Override
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
            System.out.println(" n--\n" +
                    "/O\\--\n" +
                    "_|/--\n" +
                    " |--\n" +
                    "/ \\--");
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  (Fighter)super.clone();
    }

    @Override
    public String toString() {
        return "RogueMage {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", magicDamage=" + magicDamage +
                ", critChance=" + critChance +
                "%, lifePoints=" + lifePoints +
                ", dodgeChance=" + dodgeChance +
                "%, initiative=" + initiative +
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
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}
class Fou implements Cloneable,Fighter{
    Random random = new Random();
    protected String name;
    protected int damage;
    protected int initiative;
    protected int lifePoints;
    protected int mentalSanity;
    protected int team;

    public Fou(String name, int damage, int lifePoints, int initiative,int mentalSanity){
        this.damage = damage;
        this.initiative = initiative;
        this.lifePoints = lifePoints;
        this.name = name;
        this.mentalSanity = mentalSanity;
    }

    public int getDamage(){
        int min = 0;
        int max = 100;

        int value = random.nextInt(max +min + 1) + min;

        if (value <= mentalSanity){
            System.out.println("Self attack");
            System.out.println(",n,\n" +
                    "°ø° \n" +
                    " |\\\n" +
                    "/| \\\n" +
                    "/ \\ \\");
            lifePoints -= damage;
            System.out.println(name + " lost " + damage + " and have now " + lifePoints + " HP");
            return 0;
        }
        else {
            System.out.println(name + " use is staff");
            System.out.println(",n,_\n" +
                    "°O°(/(\n" +
                    " |_/ )\n" +
                    "/|/( (\n" +
                    "//\\) (");
            return this.damage*3;
        }
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

    @Override
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
    }

    public int takeDamage(int Damage){
        this.lifePoints -= Damage;
        return Damage;
    }

    public Object clone() throws CloneNotSupportedException {
        return  (Fighter)super.clone();
    }

    public String toString() {
        return "Foul {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", mentalSanity=" + mentalSanity +
                ", lifePoints=" + lifePoints +
                ", initiative=" + initiative +
                '}';
    }
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}

class Shooter implements Cloneable, Fighter{
    Random random = new Random();
    protected String name;
    protected int damage;
    protected int lifePoints;
    protected int initiative;
    protected int accuracy;
    protected int team;


    public Shooter(String name, int damage, int lifePoints, int initiative, int accuracy) {
        this.name = name;
        this.damage = damage;
        this.lifePoints = lifePoints;
        this.initiative = initiative;
        this.accuracy = accuracy;
        ;

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
        int min2 = -this.accuracy;
        int max2 = this.accuracy;

        int value = random.nextInt(max +min + 1) + min;
        int accuracy = random.nextInt(max2 +min2 + 1) + min;

        if ((value + accuracy) > 98){
            System.out.println(this.name + " shot in the head");
            return this.damage*10;
        }
        else if ((value + accuracy) > 35 && (value + accuracy) < 98){
            System.out.println(this.name + " shot in the chest");
            return this.damage;
        }
        else if ((value + accuracy) > 15 && (value + accuracy) < 35){
            System.out.println(this.name + " shot in the limbs");
            return this.damage/2;
        }
        else if ((value + accuracy) > 5 && (value + accuracy) < 15){
            System.out.println(this.name + " shot in the foot");
            return this.damage/4;
        }
        else{
            System.out.println(this.name + " missed his shot");
            return 0;
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

    @Override
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public int getTeam() {
        return this.team;
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
    public String toString() {
        return "Shooter {" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                "%, lifePoints=" + lifePoints +
                "%, initiative=" + initiative +
                "accuracy=" + accuracy +
                '}';
    }
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
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






