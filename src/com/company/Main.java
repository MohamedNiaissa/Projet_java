package com.company;
import java.util.Scanner;
public class Main {
    public static void display_menu() {
        System.out.println ( "1) Create basic recruit 1\n2) Create recruit \n3) Option 3 \n4) display character \n5) quit" );
        System.out.print ( "Selection: " );
    }
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in );
        Recruit recruit = new Recruit("didier",100,1000,50);
        ListPerso list = new ListPerso();
        boolean cont = true;
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
                    System.out.println("choissiser un montant de dégats: ");
                    int dmg = in.nextInt();
                    System.out.println("choissiser un montant de point de vie: ");
                    int lp = in.nextInt();
                    System.out.println("choissiser un montant d'initiative: ");
                    int ini = in.nextInt();
                    Recruit recruit1 = new Recruit(name, dmg, lp, ini);
                    list.addListePerso(recruit1);
                    break;
                case 3:
                    System.out.println("You picked option 3");
                    break;
                case 4:
                    System.out.println("quel personnage voulez vous voir");
                    int index = in.nextInt();
                    list.displayChar(index);
                    break;
                case 5:
                    cont = false;
                    break;
                default:
                    System.err.println("Unrecognized option");
                    break;
            }
        }
    }
}
