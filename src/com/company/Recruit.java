package com.company;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static java.nio.file.StandardOpenOption.*;

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
        System.out.println(name + " use his pitchfork");
        System.out.println("""
                  \s
                   /
                 O \\/
                 |_/\\/
                 |/
                //\\""");
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
        return super.clone();
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


    public String toStringFile() {

        return  "Name="+ name +
                "\nClass_"+ name +"=Recruit" +
                "\nName_"+ name + "="+ name +
                "\nDamage_"+ name + "=" + damage +
                "\nLifePoints_" + name + "=" + lifePoints +
                "\nInitiative_"+ name +"=" + initiative + "\n";

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
        System.out.println("""
                <n>
                 O  /\\
                 |-/\\/
                /|\s
                / \\""");
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

    @Override
    //return the right amount of damage after the mitigation of the shield
    public int takeDamage(int damage){
        if (damage-shieldres<=0){
            System.out.println(name + " have blocked all damage");
            System.out.println("""
                    <n>
                     O ___
                     |-| |
                    /| \\_/
                    / \\""");
            return 0;
        } else {
            System.out.println("The shield of " + name + " blocked " + shieldres);
            lifePoints -= damage-shieldres;
            System.out.println("""
                    <n>
                     O ___
                     |-| |
                    /| \\_/
                    / \\""");
            return damage-shieldres;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
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
    public String toStringFile() {
        return  "Name"+"="+name+
                "\nClass_"+ name +"=Warrior" +
                "\nName_"+name+ "="+ name +
                "\nDamage_"+name+ "=" + damage +
                "\nLifePoints_" +name+ "=" + lifePoints +
                "\nShieldResistance_" +name+"=" + shieldres +
                "\nInitiative_"+name+"=" + initiative + "\n";
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
            System.out.println("""
                    _n_
                     O  O  -/\\
                     |-/   -\\/
                    /|
                    / \\""");
        }else{
            System.out.println(name + " use is staff");
            System.out.println("""
                    _n_
                     O  O
                     |-/
                    /|\s
                    / \\""");
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
        return super.clone();
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
    public String toStringFile() {
        return  "Name"+"="+name+
                "\nClass_" + name +"=Magician " +
                "\nName_"+ name + "=" + name +
                "\nDamage_" +name+ "=" + damage +
                "\nLifePoints_" +name+ "=" + lifePoints +
                "\nInitiative_" + name+ "=" + initiative +
                "\nMagicDamage_"+ name +"=" + magicDamage + "\n";
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
    protected int critChance;
    protected int dodgeChance;
    protected int critcount = 0;

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
        int max = 100;

        int value = random.nextInt(max + 1);

        if (value <= critChance && critcount == 0){
            critcount++;
            System.out.println(name + " do a Critical Hit !");
            System.out.println("""
                     n
                    /O\\,/!
                     |_/`:
                    /|   :
                    / \\ _¡_""");
            return this.damage*2;
        }
        else {
            System.out.println(name + " use is knife");
            System.out.println("""
                     n
                    /O\\,/
                     |_/`
                    /|
                    / \\""");
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
        int max = 100;

        int value = random.nextInt(max+ 1);

        if (value > dodgeChance){
            this.lifePoints -= Damage;
            return Damage;
        }
        else{
            System.out.println(this.name + " dodged the hit");
            System.out.println("""
                     n--
                    /O\\--
                    _|/--
                     |--
                    / \\--""");
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
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
    public String toStringFile() {
        return  "Name"+"="+ name
                +"\nClass_"+ name + "=Rogue" +
                "\nName_" + name + "=" + name +
                "\nDamage_" + name + "=" + damage +
                "\nCritChance_" +name + "=" + critChance +
                "\nLifePoints_"+name+ "=" + lifePoints +
                "\nDodgeChance_"+name+"=" + dodgeChance +
                "\nInitiative_"+name+"=" + initiative + "\n"
                ;
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
    protected int critcount = 0;

    Random random = new Random();
    @Override
    public String toStringFile() {
        return  "Name"+"="+name
                +"\nClass_"+name+ "=RogueWarrior" +
                "\nName_" + name + "=" + name +
                "\nDamage_" + name + "=" + damage +
                "\nCritChance_" +name + "=" + critChance +
                "\nLifePoints_"+name+ "=" + lifePoints +
                "\nShieldResistance_" +name+"=" + shieldres +
                "\nDodgeChance_"+name+"=" + dodgeChance +
                "\nInitiative_"+name+"=" + initiative + "\n"
                ;
    }
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
        int max = 100;

        int value = random.nextInt(max + 1);

        if (value <= critChance && critcount == 0){
            critcount++;
            System.out.println(name + " do a Critical Hit !");
            System.out.println("""
                    <n>  /!
                    /O\\,/ :
                     |_/` :
                    /|    :
                    / \\  _¡_""");
            return this.damage*2;
        }
        else {
            System.out.println(name + " use is blade");
            System.out.println("""
                    <n>  /
                    /O\\,/
                     |_/`
                    /|  \s
                    / \\""");
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

        int max = 100;

        int value = random.nextInt(max + 1);

        if (value > dodgeChance){
            if (damage-shieldres<=0){
                System.out.println(name + " have blocked all damage");
                System.out.println("""
                        <n>
                        /O\\___
                         |_| |
                        /| \\_/
                        / \\""");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                return 0;
            } else {
                System.out.println("The shield of " + name + " have blocked " + shieldres);
                lifePoints -= damage - shieldres;
                System.out.println("""
                        <n>
                        /O\\___
                         |_| |
                        /| \\_/
                        / \\""");
                return damage - shieldres;
            }
        }
        else{
            System.out.println(this.name + " dodged the hit");
            System.out.println("""
                    <n>--
                    /O\\--
                    _|/--
                     |--
                    / \\--""");
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
    public String toStringFile() {
        return  "Name"+"="+name
                +"\nClass_"+name+ "=MagicWarrior" +
                "\nName_" + name + "=" + name +
                "\nDamage_" + name + "=" + damage +
                "\nMagicDamage_"+ name +"=" + magicDamage +
                "\nLifePoints_"+name+ "=" + lifePoints +
                "\nShieldResistance_" +name+"=" + shieldres +
                "\nInitiative_"+name+"=" + initiative + "\n"
                ;
    }
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
            System.out.println(name + " use magic on his sword");
            System.out.println("""
                          _
                     _   //|
                    () ///
                     O \\//
                     |_/\\
                    /|\s
                    / \\""");
        }else{
            System.out.println(name + " use his sword");
            System.out.println("""
                     _    /
                    ()  /
                     O \\/
                     |_/\\
                    /|\s
                    / \\""");
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
            System.out.println(name + " have blocked all damage");
            System.out.println("""
                     _
                    ()
                     O ___
                     |_| |
                    /| \\_/
                    / \\""");
            return 0;
        } else {
            System.out.println("The shield of " + name + " blocked " + shieldres);
            lifePoints -= damage-shieldres;
            System.out.println("""
                     _
                    ()
                     O ___
                     |_| |
                    /| \\_/
                    / \\""");
            return damage-shieldres;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
    protected int critChance;
    protected int dodgeChance;
    protected int critcount = 0;
    Random random = new Random();
    @Override
    public String toStringFile() {
        return  "Name"+"="+ name
                +"\nClass_"+ name + "=RogueMage" +
                "\nName_" + name + "=" + name +
                "\nDamage_" + name + "=" + damage +
                "\nMagicDamage_"+ name +"=" + magicDamage +
                "\nCritChance_" +name + "=" + critChance +
                "\nLifePoints_"+name+ "=" + lifePoints +
                "\nDodgeChance_"+name+"=" + dodgeChance +
                "\nInitiative_"+name+"=" + initiative + "\n"
                ;
    }
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
        int max = 100;
        int totalDamage = damage + magicDamage;
        magicDamage /= 2;
        int value = random.nextInt(max + 1);

        if (value <= critChance && critcount == 0){
            critcount++;
            System.out.println(name + " have do a Critical hit !");
            if (magicDamage > 0){
                System.out.println(name + "use a magic stinger");
                System.out.println("""
                        _n_  *
                         O ,/  --->
                         |-/`
                        /|
                        / \\""");
            }else{
                System.out.println(name + " use is knife");
                System.out.println("""
                        _n_
                        /O\\,/!
                         |_/':
                        /|   :
                        / \\ _!_""");
            }
            return totalDamage*2;
        }
        else {
            if (magicDamage > 0){
                System.out.println(name + "use a magic bolt");
                System.out.println("""
                        _n_  *
                        /O\\,/   -/\\
                         |-/'   -\\/
                        /|
                        / \\""");
            }else{
                System.out.println(name + "use his knife");
                System.out.println("""
                        _n_
                        /O\\,/
                         |-/'
                        /|\s
                        / \\""");
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
        int max = 100;

        int value = random.nextInt(max + 1);

        if (value > dodgeChance){
            this.lifePoints -= Damage;
            return Damage;
        }
        else{
            System.out.println(this.name + " dodged the hit");
            System.out.println("""
                     n--
                    /O\\--
                    _|/--
                     |--
                    / \\--""");
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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

    @Override
    public String toStringFile() {
        return  "Name"+"="+name
                +"\nClass_"+name+ "=Fool" +
                "\nName_" + name + "=" + name +
                "\nDamage_" + name + "=" + damage +
                "\nMentalSanity_" + name + "=" + mentalSanity +
                "\nLifePoints_"+name+ "=" + lifePoints +
                "\nInitiative_"+name+"=" + initiative + "\n"
                ;
    }
    public Fou(String name, int damage, int lifePoints, int initiative,int mentalSanity){
        this.damage = damage;
        this.initiative = initiative;
        this.lifePoints = lifePoints;
        this.name = name;
        this.mentalSanity = mentalSanity;
    }

    public int getDamage(){
        int max = 100;

        int value = random.nextInt(max + 1);

        if (value <= mentalSanity){
            System.out.println(name + "do a Self attack !");
            System.out.println("""
                    ,n,
                    °ø°\s
                     |\\
                    /| \\
                    / \\ \\""");
            lifePoints -= damage;
            System.out.println(name + " lost " + damage + " and have now " + lifePoints + " HP");
            return 0;
        }
        else {
            System.out.println(name + " use is 'conjuring' staff");
            System.out.println("""
                    ,n,_
                    °O°(/(
                     |_/ )
                    /|/( (
                    //\\) (""");
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
        return super.clone();
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

    public String toStringFile() {

        return  "Name="+ name +
                "\nClass_"+ name +"=Shooter" +
                "\nName_"+ name + "="+ name +
                "\nDamage_"+ name + "=" + damage +
                "\nAccuracy_" + name + "=" + accuracy +
                "\nLifePoints_" + name + "=" + lifePoints +
                "\nInitiative_"+ name +"=" + initiative + "\n";

    }
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
        int max = 100;
        int min2 = -this.accuracy;
        int max2 = this.accuracy;

        int value = random.nextInt(max + 1);
        int accuracy = random.nextInt(max2 + min2 + 1);

        if ((value + accuracy) > 98){
            System.out.println(this.name + " shot in the head");
            System.out.println("""
                      ,
                     C≥\s
                     O|\\  -->—|>
                    -||_|
                     ||/
                    / \\""");
            return this.damage*10;
        }
        else if ((value + accuracy) > 35 && (value + accuracy) < 98){
            System.out.println(this.name + " shot in the chest");
            System.out.println("""
                      ,
                     C≥\s
                     O|\\
                    -||_| -->—|>
                     ||/
                    / \\""");
            return this.damage;
        }
        else if ((value + accuracy) > 15 && (value + accuracy) < 35){
            System.out.println(this.name + " shot in the limbs");
            System.out.println("""
                      ,
                     C≥\s
                     O|\\
                    -||_|
                     ||/  -->—|>
                    / \\""");
            return this.damage/2;
        }
        else if ((value + accuracy) > 5 && (value + accuracy) < 15){
            System.out.println(this.name + " shot in the foot");
            System.out.println("""
                      ,
                     C≥\s
                     O|\\
                    -||_|
                     ||/
                    / \\   -->—|>""");
            return this.damage/4;
        }
        else{
            System.out.println(this.name + " missed his shot");
            System.out.println("""
                      ,
                     C≥\s
                     O|\\
                    -||_|
                     ||/      U
                    / \\      _|_""");
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
                ", lifePoints=" + lifePoints +
                ", initiative=" + initiative +
                "%, accuracy=" + accuracy +
                '}';
    }
    @Override
    public int compareTo(Fighter o) {
        return -Integer.compare(this.initiative, o.getInitiative());
    }
}


class Saitama implements Cloneable,Fighter{
    Random random = new Random();
    protected String name;
    protected int damage;
    protected int initiative;
    protected int lifePoints;
    protected int team;
    protected int critChance;
    protected int dodgeChance;



    public Saitama(String name,int damage,int initiative,int lifePoints,int critChance,int dodgeChance){
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
        this.damage= damage;

    }

    @Override
    public int getDamage() {
        int max = 100;

        int value = random.nextInt(max+1);

        if (value <= critChance){
            System.out.println(name + " did a one PUUUUUUUUUNCH !!");
            System.out.println("""
                     /---
                 O  /----
                 |-<-----
                /|  \\----
                / \\  \\---""");

            System.out.println(name + " : Seems like the fight is finished, it was not funny.... ");

            int damageSaitama = this.damage*10000;

            return damageSaitama;


        }else{
            System.out.println("Seems like  "+name + " doesn't want to attack");
            System.out.println("""
                \s
                 O no
                 |
                /|\\
                / \\""");
            return 0;
        }
    }

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints*3;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative/2;

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
    public int takeDamage(int damage) {

        int max = 100;

        int value = random.nextInt(max + 1);

        if (value > dodgeChance+100){
            this.lifePoints -= damage;
            return damage;
        }else{
            return damage =0;
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Saitama {" +
                " name='" + name + '\'' +
                ",damage=" + damage +
                ",lifePoints=" + lifePoints +
                ",initiative=" + initiative +
                ",critChance=" + critChance +
                ",dodgeChance=" + dodgeChance +
                '}';
    }

    @Override
    public String toStringFile()  {
        return  "Name"+"="+ name
                +"\nClass_"+ name + "=Saitama" +
                "\nName_" + name + "=" + name +
                "\nDamage_" + name + "=" + damage +
                "\nCritChance_" +name + "=" + critChance +
                "\nLifePoints_"+name+ "=" + lifePoints +
                "\nDodgeChance_"+name+"=" + dodgeChance ;
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
    public void importsave(String output){
        try (FileReader reader = new FileReader(output)) { // /Users/mohamed/Documents/ProjetJava/Projet_java/src/com/company/char.txt
            Properties properties = new Properties();
            properties.load(reader);
            int getnbperso = Integer.parseInt(properties.getProperty("Nombreperso"));
            for (int i=1;i<=getnbperso;i++) {
                String getnameChar = properties.getProperty(i+"Name");


                //System.out.println("Blase : "+getnameChar);

                // System.out.println(classChar);

                String nameChar = properties.getProperty("Name_" + getnameChar);
                String damageChar = properties.getProperty("Damage_" + getnameChar);
                int damageCharInt = Integer.parseInt(damageChar);
                String lifePointChar = properties.getProperty("LifePoints_" + getnameChar);
                int lifePointCharInt = Integer.parseInt(lifePointChar);
                String initiativeChar = properties.getProperty("Initiative_" + getnameChar);
                int initiativeCharInt = Integer.parseInt(initiativeChar);

                String shieldResistanceChar = properties.getProperty("ShieldResistance_" + getnameChar);
                String magicDamageChar = properties.getProperty("MagicDamage_" + getnameChar);
                String critChanceChar = properties.getProperty("CritChance_" + getnameChar);
                String dodgeChanceChar = properties.getProperty("DodgeChance_" + getnameChar);
                String accuracy = properties.getProperty("Accuracy_" + getnameChar);
                String MentalSanity = properties.getProperty("MentalSanity_" + getnameChar);

                if (accuracy != null) {
                    int accuracyInt = Integer.parseInt(accuracy);
                    Shooter shooterChar = new Shooter(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt, accuracyInt);
                    addListePerso(shooterChar);

                } else if (MentalSanity != null){
                    int MentalSanityInt = Integer.parseInt(MentalSanity);
                    Fou foolChar = new Fou(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt,MentalSanityInt);
                    addListePerso(foolChar);

                } else if (magicDamageChar != null && shieldResistanceChar != null) {
                    int magicDamageCharInt = Integer.parseInt(magicDamageChar);
                    int shieldResistanceCharInt = Integer.parseInt(shieldResistanceChar);
                    MageGuerrier magewarriorChar = new MageGuerrier(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt, shieldResistanceCharInt, magicDamageCharInt);
                    addListePerso(magewarriorChar);

                }else if (magicDamageChar != null && dodgeChanceChar != null && critChanceChar != null) {
                    System.out.println("entrée");
                    int magicDamageCharInt = Integer.parseInt(magicDamageChar);
                    int critChanceCharInt = Integer.parseInt(critChanceChar);
                    int dodgeChanceCharInt = Integer.parseInt(dodgeChanceChar);
                    MageVoleur roguemageChar = new MageVoleur(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt,magicDamageCharInt,critChanceCharInt,dodgeChanceCharInt);
                    addListePerso(roguemageChar);

                }else if (magicDamageChar != null) {
                    int magicDamageCharInt = Integer.parseInt(magicDamageChar);
                    Magician mageChar = new Magician(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt, magicDamageCharInt);
                    addListePerso(mageChar);

                } else if (dodgeChanceChar != null && critChanceChar != null && shieldResistanceChar != null) {
                    int critChanceCharInt = Integer.parseInt(critChanceChar);
                    int dodgeChanceCharInt = Integer.parseInt(dodgeChanceChar);
                    int shieldResistanceCharInt = Integer.parseInt(shieldResistanceChar);
                    GuerrierVoleur roguewarriorChar = new GuerrierVoleur(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt, critChanceCharInt, dodgeChanceCharInt,shieldResistanceCharInt);
                    addListePerso(roguewarriorChar);

                }else if (dodgeChanceChar != null && critChanceChar != null) {
                    int critChanceCharInt = Integer.parseInt(critChanceChar);
                    int dodgeChanceCharInt = Integer.parseInt(dodgeChanceChar);
                    Rogue rogueChar = new Rogue(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt, critChanceCharInt, dodgeChanceCharInt);
                    addListePerso(rogueChar);

                } else if (shieldResistanceChar != null) {
                    int shieldResistanceCharInt = Integer.parseInt(shieldResistanceChar);
                    Warrior rogueChar = new Warrior(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt, shieldResistanceCharInt);
                    addListePerso(rogueChar);

                } else {
                    Recruit recruitChar = new Recruit(nameChar, damageCharInt, lifePointCharInt, initiativeCharInt);
                    addListePerso(recruitChar);

                }
            }


        } catch (Exception e) {
            System.out.println("Error in the process of loading the file " + e);
        }
    }
    public void exportsave(String outputFile){

        Path chemin = Paths.get(outputFile);
        String save = "Nombreperso=" + listePerso.size() + "\n";

        for (int i = 0; i < listePerso.size(); i++) {
            save += (i+1)+listePerso.get(i).toStringFile();
        }

        byte[] data = save.getBytes();

        OutputStream output = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(chemin, CREATE, TRUNCATE_EXISTING));
            output.write(data);
            output.flush();
            output.close();
            System.out.println("sauvegarde effectué");
        } catch (Exception e) {
            System.out.println("Message " + e);
        }

    }



}






