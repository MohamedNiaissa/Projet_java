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
        Scanner charDefault = new Scanner(System.in);
        Scanner liste = new Scanner(System.in);

        Recruit recruitDefault = new Recruit("didier",100,1000,50);
        Recruit wariorDefault = new Warrior("Hercule",120,900,100,20);
        Recruit mageDefault = new Magician("Mesmer",90,1000,50,70);
        Recruit roguedDefault = new Rogue("Naruto",100,800,90, 50,20);
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
                    System.out.println("Choose the type : \n1) Basic recruit \n2) Warior  \n3) Mage \n4) Rogue");

                    switch (charDefault.nextInt()){
                        case 1:
                            System.out.println(recruitDefault);
                            list.addListePerso(recruitDefault);
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            System.out.println(wariorDefault);
                            list.addListePerso(wariorDefault);
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            break;

                        case 3:
                            System.out.println(mageDefault);
                            list.addListePerso(mageDefault);
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            break;

                        case 4:
                            System.out.println(roguedDefault);
                            list.addListePerso(roguedDefault);
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            break;

                    }
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
                    System.out.println("entrer the name of your character: ");
                    String namewar = in.next();
                    System.out.println("choose a damage amount: ");
                    int dmgwar = in.nextInt();
                    System.out.println("choose an amount of life points: ");
                    int lpwar = in.nextInt();
                    System.out.println("choose an amount of shield resistance: ");
                    int shieldwar = in.nextInt();
                    System.out.println("choose an initative amount: ");
                    int iniwar = in.nextInt();
                    Recruit warrior1 = new Warrior(namewar, dmgwar, lpwar, iniwar, shieldwar);
                    list.addListePerso(warrior1);
                    break;


                case 4:
                    System.out.println("entrer the name of your character: ");
                    String nameMag = in.next();
                    System.out.println("choose a damage amount: ");
                    int dmgMag = in.nextInt();
                    System.out.println("choose an amount of life points: ");
                    int lpMag = in.nextInt();
                    System.out.println("choose an initative amount: ");
                    int iniMag = in.nextInt();
                    System.out.println("choose an amount of magic damage: ");
                    int dmgMagBonus = in.nextInt();
                    Recruit magician = new Magician(nameMag, dmgMag, lpMag, iniMag,dmgMagBonus);
                    list.addListePerso(magician);
                    break;



                case 5:
                    System.out.println("entrer the name of your character: ");
                    String name1 = in.next();
                    System.out.println("choose a damage amount: ");
                    int dmg1 = in.nextInt();
                    System.out.println("choose an amount of life points: ");
                    int lp1 = in.nextInt();
                    System.out.println("choose an initative amount: ");
                    int ini1 = in.nextInt();
                    System.out.println("choose a probability of critical chance: ");
                    int crit = in.nextInt();
                    System.out.println("choose a probability of dodge chance: ");
                    int dodge = in.nextInt();
                    Recruit rogue = new Rogue(name1, dmg1, lp1, ini1,crit,dodge);
                    list.addListePerso(rogue);
                case 6:
                    list.displayList();
                    System.out.println("Come back to the menu : (Press Enter)");
                    String valUser = liste.nextLine();
                    break;


                case 7:
                    System.out.println("Which character do you want to see : ");
                    int index = in.nextInt();
                    list.displayChar(index);
                    System.out.println("Come back to the menu : (Press Enter)");
                    String continutoMenu = liste.nextLine();
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



                case 8:
                    System.out.println("You have just left the simulation");
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
                    System.out.println("Choose your first character : ");
                    int indexPerso1 = in.nextInt();
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

                    System.out.println("Choose your second character : ");
                    int indexPerso2 = in.nextInt();
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
                        System.out.println(Perso1.getName() + " start");
                    }
                    else if(Perso1.getInitiative()< Perso2.getInitiative()){
                        System.out.println(Perso2.getName() + " start");
                    }else {
                        Recruit[] tabPerso = {Perso1,Perso2};
                        int randFirst = new Random().nextInt(tabPerso.length);
                        chooseChar = tabPerso[randFirst];
                        System.out.println("Same initiative, so random draw : " + chooseChar.getName());
                    }
                    while (fight){
                        int nbtour = 0;
                        if (Perso1.getInitiative() > Perso2.getInitiative()){
                            nbtour++;
                            int domage;
                            if (Perso1.getLifePoints() > 0){
                                domage = Perso1.getDamage();
                                domage = Perso2.takeDamage(domage);
                                System.out.println(Perso1.getName() + " inflicted " + domage + " to " + Perso2.getName() + " he has " +Perso2.getLifePoints() + " left"  );
                                System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                            }
                            else{
                                System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left. ");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String goToMenu = liste.nextLine();
                                fight = false;
                                break;
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
                                System.out.println(Perso2.getName() + " inflicted " + domage + " to " + Perso1.getName() + " he has " + Perso1.getLifePoints() + " left");
                                System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                            }
                            else{
                                System.out.println(Perso1.getName() + " wins with " + Perso1.getLifePoints() + " left");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String goMenu = liste.nextLine();
                                fight = false;
                                break;
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
                                System.out.println(Perso2.getName() + " inflected " + domage + " to " + Perso1.getName() + "  he has " + Perso1.getLifePoints() + " left");
                                System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                            }
                            else{
                                System.out.println(Perso1.getName() + "  wins with " + Perso1.getLifePoints() + " left");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String gotoMenu = liste.nextLine();
                                fight = false;
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
                                System.out.println(Perso1.getName() + " inflected " + domage + " to " + Perso2.getName() + " he has " + Perso2.getLifePoints()+ " left");
                                System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                            }
                            else{
                                System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String continuToMenu = liste.nextLine();
                                fight = false;
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
                                    System.out.println(Perso1.getName() + " inflected " + domage + " to " + Perso2.getName() + " he has " + Perso2.getLifePoints() + " left ");
                                    System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                                }
                                else{
                                    System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String displayMenu = liste.nextLine();
                                    fight = false;
                                    break;
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
                                    System.out.println(Perso2.getName() + " inflected " + domage + " to " + Perso1.getName() + " he has " + Perso1.getLifePoints()+ " left ");
                                    System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                                }
                                else{
                                    System.out.println(Perso1.getName() + " wins with " + Perso1.getLifePoints() + " left ");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String displaymenu = liste.nextLine();
                                    fight = false;
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
                                    System.out.println(Perso2.getName() + " inflected " + domage + " to " + Perso1.getName() + " he has " + Perso1.getLifePoints()+ " left");
                                    System.out.println("Tour " + nbtour + " : " + Perso2.getName() + " à infligé " + domage + " à " + Perso1.getName() + " il lui reste " + Perso1.getLifePoints());
                                }
                                else{
                                    System.out.println(Perso1.getName() + " wins with " + Perso1.getLifePoints() + " left");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String openMenu = liste.nextLine();
                                    fight = false;
                                    break;
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
                                    System.out.println(Perso1.getName() + " inflected " + domage + " to " + Perso2.getName() + "  he has " + Perso2.getLifePoints() + " left");
                                    System.out.println("Tour " + nbtour + " : " + Perso1.getName() + " à infligé " + domage + " à " + Perso2.getName() + " il lui reste " + Perso2.getLifePoints());
                                }
                                else{
                                    System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String menu = liste.nextLine();
                                    fight = false;
                                    break;
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


                case 10:
                    list.displayList();
                    System.out.println("Choose the character to delete");
                    index = in.nextInt();
                    list.removeList(index - 1);
                    list.displayList();
                    break;



                default:

                    System.err.println("Unrecognized option");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
