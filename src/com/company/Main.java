package com.company;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void display_menu() {
        System.out.println ( "1) Create default \n2) Create recruit \n3) Create warrior \n4) Create mage \n" +
         "5) Create rogue \n6) List \n7) display character \n8) quit \n9) Fight \n10) Remove from list" );
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
                    break;



                case 8:
                    System.out.println("You have just left the simulation");
                    cont = false;
                    break;


                case 9:
                    list.displayList();
                    System.out.println("Choose your first character : ");
                    int indexPerso1 = in.nextInt();
                    Recruit Perso = list.getRecruit(indexPerso1);
                    Recruit Perso1 = (Recruit)Perso.clone();

                    System.out.println("Choose your second character : ");
                    int indexPerso2 = in.nextInt();
                    Recruit PersoBis = list.getRecruit(indexPerso2);
                    Recruit Perso2 = (Recruit)PersoBis.clone();

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
                        if (Perso1.getInitiative() > Perso2.getInitiative()){
                            int domage;
                            if (Perso1.getLifePoints() > 0){
                                domage = Perso1.getDamage();
                                domage = Perso2.takeDamage(domage);
                                System.out.println(Perso1.getName() + " inflicted " + domage + " to " + Perso2.getName() + " he has " +Perso2.getLifePoints() + " left"  );
                            }
                            else{
                                System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left. ");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String goToMenu = liste.nextLine();
                                fight = false;
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
                            }
                            else{
                                System.out.println(Perso1.getName() + " wins with " + Perso1.getLifePoints() + " left");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String goMenu = liste.nextLine();
                                fight = false;
                                break;
                            }
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        else if (Perso2.getInitiative()> Perso1.getInitiative()){
                            int domage;
                            if (Perso2.getLifePoints() > 0){
                                domage = Perso2.getDamage();
                                domage = Perso1.takeDamage(domage);
                                System.out.println(Perso2.getName() + " inflected " + domage + " to " + Perso1.getName() + "  he has " + Perso1.getLifePoints() + " left");
                            }
                            else{
                                System.out.println(Perso1.getName() + "  wins with " + Perso1.getLifePoints() + " left");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String gotoMenu = liste.nextLine();
                                fight = false;
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
                            }
                            else{
                                System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left");
                                System.out.println("Come back to the menu : (Press Enter)");
                                String continuToMenu = liste.nextLine();
                                fight = false;
                            }
                            try{
                                Thread.sleep(1500);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }else{
                            
                            if( chooseChar == Perso1 ){
                                int domage;
                                if (Perso1.getLifePoints() > 0){
                                    domage = Perso1.getDamage();
                                    domage = Perso2.takeDamage(domage);
                                    System.out.println(Perso1.getName() + " inflected " + domage + " to " + Perso2.getName() + " he has " + Perso2.getLifePoints() + " left ");
                                }
                                else{
                                    System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String displayMenu = liste.nextLine();
                                    fight = false;
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
                                }
                                else{
                                    System.out.println(Perso1.getName() + " wins with " + Perso1.getLifePoints() + " left ");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String displaymenu = liste.nextLine();
                                    fight = false;
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
                                }
                                else{
                                    System.out.println(Perso1.getName() + " wins with " + Perso1.getLifePoints() + " left");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String openMenu = liste.nextLine();
                                    fight = false;
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
                                }
                                else{
                                    System.out.println(Perso2.getName() + " wins with " + Perso2.getLifePoints() + " left");
                                    System.out.println("Come back to the menu : (Press Enter)");
                                    String menu = liste.nextLine();
                                    fight = false;
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
