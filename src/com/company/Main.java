package com.company;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void display_menu() {
        System.out.println ( "1) Create basic recruit | 6) List\n2) Create recruit       | 7) display character\n3) Create warrior       | 8) Remove character\n4) Create mage          | 9) Fight\n" +
         "5) Create rogue         | 10) Save \n11) Quit" );
        System.out.print ( "Selection: " );
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner in = new Scanner ( System.in );
        Recruit recruit = new Recruit("didier",100,1000,50);
        Recruit Rogue = new Rogue("gerard",100,800,90, 50,20);
        ListPerso list = new ListPerso();
        Recruit chooseChar = null;
        boolean cont = true;
        System.out.println("Welcome in \n--¡-- __     ___      __ |        /\\   __ __     ¡ _  __ ___ __   ¡--\\ __ ______| __   /--\\'  _   _       | __ ___ _ ¡ _   |||\n" +
                                        "  |  /__\\ \\/  | |   |/  ||\\  /   /__\\ /  /  |   ||/  /  | | /__\\  |--</  | |  | |/__\\  '--.||/ \\ / \\ |   ||/  | | / \\|/    |||\n" +
                                        "  |  \\__; /\\  |  \\_/|\\__|| \\/   /    \\\\__\\__ \\_/||   \\__| | \\__;  |__/\\__| |  | |\\__;  \\__/||   |   | \\_/||\\__| | \\_/|     ...\n" +
                                        "                          _/");
        System.out.println("Appuyez sur entrée pour accéder au menu");
        String wait = in.nextLine();
        while(cont) {
            display_menu();
            switch (in.nextInt()) {
                case 1:
                    System.out.println(recruit);
                    list.addListePerso(recruit);
                    break;
                case 2:
                    System.out.println("entrer le nom de votre personnage: ");
                    String name = in.next();
                    System.out.println("choisissez un montant de dégats: ");
                    int dmg = in.nextInt();
                    System.out.println("choisissez un montant de point de vie: ");
                    int lp = in.nextInt();
                    System.out.println("choisissez un montant d'initiative: ");
                    int ini = in.nextInt();
                    Recruit recruit1 = new Recruit(name, dmg, lp, ini);
                    list.addListePerso(recruit1);
                    break;
                case 3:
                    System.out.println("entrer le nom de votre personnage: ");
                    String namewar = in.next();
                    System.out.println("choisissez un montant de dégats: ");
                    int dmgwar = in.nextInt();
                    System.out.println("choisissez un montant de point de vie: ");
                    int lpwar = in.nextInt();
                    System.out.println("choisissez un montant de résistance du bouclier: ");
                    int shieldwar = in.nextInt();
                    System.out.println("choisissez un montant d'initiative: ");
                    int iniwar = in.nextInt();
                    Recruit warrior1 = new Warrior(namewar, dmgwar, lpwar, iniwar, shieldwar);
                    list.addListePerso(warrior1);
                    break;
                case 4:
                    System.out.println("entrer le nom de votre personnage: ");
                    String nameMag = in.next();
                    System.out.println("choisissez un montant de dégats: ");
                    int dmgMag = in.nextInt();
                    System.out.println("choisissez un montant de point de vie: ");
                    int lpMag = in.nextInt();
                    System.out.println("choisissez un montant d'initiative: ");
                    int iniMag = in.nextInt();
                    System.out.println("Choisssez un montant de degat magique: ");
                    int dmgMagBonus = in.nextInt();
                    Recruit magician = new Magician(nameMag, dmgMag, lpMag, iniMag,dmgMagBonus);
                    list.addListePerso(magician);
                    break;
                case 5:
                    System.out.println("entrer le nom de votre personnage: ");
                    String name1 = in.next();
                    System.out.println("choisissez un montant de dégats: ");
                    int dmg1 = in.nextInt();
                    System.out.println("choisissez un montant de critChance");
                    int crit = in.nextInt();
                    while ((crit>100)||(crit<0)){
                        System.out.println("la valeur de critChance se situe entre 0 et 100");
                        crit = in.nextInt();
                    }
                    System.out.println("choisissez un montant de point de vie: ");
                    int lp1 = in.nextInt();
                    System.out.println("choisissez un montant de dodgeChance");
                    int dodge = in.nextInt();
                    while ((dodge>100)||(dodge<0)){
                        System.out.println("la valeur de dodgeChance se situe entre 0 et 100");
                        dodge = in.nextInt();
                    }
                    System.out.println("choisissez un montant d'initiative: ");
                    int ini1 = in.nextInt();
                    Recruit rogue = new Rogue(name1, dmg1, lp1, ini1,crit,dodge);
                    list.addListePerso(rogue);
                    break;
                case 6:
                    list.displayList();
                    System.out.println("Appuyez sur entrée pour retourner au menu");
                    wait = in.nextLine();
                    break;
                case 7:
                    boolean wantLook = true;
                    while (wantLook) {
                        System.out.println("quel personnage voulez vous voir");
                        int index = in.nextInt();
                        if ((list.sizeList() > index - 1) && (index - 1 != 0)) {
                            list.displayChar(index);
                            wantLook = false;
                        } else {
                            System.out.println("Ce personnage n'existe pas dans la liste \n Voulez vous revenir au menu ? (0) oui (1) non");
                            index = in.nextInt();
                            if (index==0){
                                wantLook = false;
                            }
                        }
                    }
                    break;
                case 11:
                    cont = false;
                    break;
                case 10:
                    System.out.println("sauvegardez(1) ou chargez(2) ou revenir sur le menu(3) ?");
                    int choose = in.nextInt();
                    while ((choose != 1)&&(choose != 2)&&(choose != 3)){
                        System.out.println();
                        choose = in.nextInt();
                    }
                    if (choose==1){
                        System.out.println("quel chemin de fichier ?");
                        String input = in.next();
                        list.exportsave(input);
                        break;
                    }else if (choose==2){
                        System.out.println("quel chemin de fichier ?");
                        String output = in.next();
                        break;
                    }else{
                        break;
                    }
                case 9:
                    boolean wantSuppr = true;
                    while (wantSuppr)
                    list.displayList();
                    System.out.println("choissisez le personnage à supprimer");
                    int index = in.nextInt();
                    if ((list.sizeList()>index-1)&&(index-1!=0)) {
                        list.displayChar(index);
                        wantSuppr=false;
                    } else {
                        System.out.println("Ce personnage n'existe pas dans la liste \n Voulez vous revenir au menu ? (0) oui (1) non");
                        index = in.nextInt();
                        if (index==0){
                            wantSuppr = false;
                        }
                    }
                    list.displayList();
                    break;
                case 8:
                    list.displayList();
                    boolean Perso1noselected= true;
                    int indexPerso1 = 0;
                    while (Perso1noselected) {
                        System.out.println("choisissez le premier personnage : ");
                        indexPerso1 = in.nextInt();
                        if ((list.sizeList()>indexPerso1-1)&&(indexPerso1-1!=0)) {
                            list.getRecruit(indexPerso1);
                            Perso1noselected = false;
                        } else {
                            System.out.println("Ce personnage n'existe pas dans la liste");
                        }
                    }
                    Recruit Perso = list.getRecruit(indexPerso1);
                    Recruit Perso1 = (Recruit)Perso.clone();
                    boolean Perso2noselected= true;
                    int indexPerso2 = 0;
                    while(Perso2noselected) {
                        System.out.println("choisissez le deuxième personnage : ");
                        indexPerso2 = in.nextInt();
                        if ((list.sizeList()>indexPerso2-1)&&(indexPerso2-1!=0)) {
                            list.getRecruit(indexPerso2);
                            Perso2noselected = false;
                        } else {
                            System.out.println("Ce personnage n'existe pas dans la liste");
                        }
                    }
                    Recruit PersoBis = list.getRecruit(indexPerso2);
                    Recruit Perso2 = (Recruit) PersoBis.clone();
                    boolean fight = true;
                    if (Perso1.getInitiative() > Perso2.getInitiative()) {
                        System.out.println(Perso1.getName() + " commence");
                    }
                    else if(Perso1.getInitiative()< Perso2.getInitiative()){
                        System.out.println(Perso2.getName() + " commence");
                    }else {
                        Recruit[] tabPerso = {Perso1,Perso2};
                        int randFirst = new Random().nextInt(tabPerso.length);
                        chooseChar = tabPerso[randFirst];
                        System.out.println("Même initiative, donc tirage au sort : " + chooseChar.getName());
                    }
                    while (fight){
                        int nbtour = 0;
                        if (Perso1.getInitiative() > Perso2.getInitiative()){
                            nbtour++;
                            int domage;
                            if (Perso1.getLifePoints() > 0){
                                domage = Perso1.getDamage();
                                domage = Perso2.takeDamage(domage);
                                System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                            }
                            else{
                                System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à gagné avec " + Perso2.getLifePoints() + " restant");
                                break;
                            }
                            try{
                                Thread.sleep(1500);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            if (Perso2.getLifePoints() > 0){
                                domage = Perso2.getDamage();
                                domage = Perso1.takeDamage(domage);
                                System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                            }
                            else{
                                System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à gagné avec " + Perso1.getLifePoints() + " restant");
                                break;
                            }
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        else if (Perso2.getInitiative()> Perso1.getInitiative()){
                            nbtour++;
                            int domage;
                            if (Perso2.getLifePoints() > 0){
                                domage = Perso2.getDamage();
                                domage = Perso1.takeDamage(domage);
                                System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                            }
                            else{
                                System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à gagné avec " + Perso1.getLifePoints() + " restant");
                                break;
                            }
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            if (Perso1.getLifePoints() > 0){
                                domage = Perso1.getDamage();
                                domage = Perso2.takeDamage(domage);
                                System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                            }
                            else{
                                System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à gagné avec " + Perso2.getLifePoints() + " restant");
                                break;
                            }
                            try{
                                Thread.sleep(1500);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }else{
                            nbtour++;
                            if( chooseChar == Perso1 ){
                                int domage;
                                if (Perso1.getLifePoints() > 0){
                                    domage = Perso1.getDamage();
                                    domage = Perso2.takeDamage(domage);
                                    System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                                }
                                else{
                                    System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à gagné avec " + Perso2.getLifePoints() + " restant");
                                    break;
                                }
                                try{
                                    Thread.sleep(500);
                                }catch(InterruptedException e){
                                    e.printStackTrace();
                                }
                                if (Perso2.getLifePoints() > 0){
                                    domage = Perso2.getDamage();
                                    domage = Perso1.takeDamage(domage);
                                    System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                                }
                                else{
                                    System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à gagné avec " + Perso1.getLifePoints() + " restant");
                                    break;
                                }
                                try{
                                    Thread.sleep(500);
                                }catch(InterruptedException e){
                                    e.printStackTrace();
                                }
                            }else {
                                int domage;
                                if (Perso2.getLifePoints() > 0){
                                    domage = Perso2.getDamage();
                                    domage = Perso1.takeDamage(domage);
                                    System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                                }
                                else{
                                    System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à gagné avec " + Perso1.getLifePoints() + " restant");
                                    break;
                                }
                                try{
                                    Thread.sleep(500);
                                }catch(InterruptedException e){
                                    e.printStackTrace();
                                }
                                if (Perso1.getLifePoints() > 0){
                                    domage = Perso1.getDamage();
                                    domage = Perso2.takeDamage(domage);
                                    System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                                }
                                else{
                                    System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à gagné avec " + Perso2.getLifePoints() + " restant");
                                    break;
                                }
                                try{
                                    Thread.sleep(500);
                                }catch(InterruptedException e){
                                    e.printStackTrace();
                                }
                            }


                        }
                    }
                    break;
                default:
                    System.err.println("Unrecognized option");
                    break;
            }
        }
    }
}
