import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random(); //RANDOM UTIL

        // Game variables
        String[] towns = {"Valentine", "Rhodes", "Lagras"}; //different towns
        int currentTown = 0;

        // Shop variables
        int amountOfSyringes = 4;

        // Player variables
        boolean playerOwnsHorse = false;
        boolean freshClothes = false;
        boolean haircut = false;
        boolean mask = false;
        int health = 100;
        int money = 50;
        int notoriety = 0;
        int strength = 1;

        boolean running = true;


        while(running) {

            if (notoriety >= 100 ) {

                System.out.println("\n\tDue to your notoriety you were pointed out to the sheriff.\n\t YOU WERE CAUGHT");

            }else if (notoriety < 0){ notoriety = 0; }


                if (health <= 0) { // Checking if you have more than 0 health
                System.out.println("\n\t YOU ARE DEAD");
                break;
            }

            if (currentTown >= towns.length) { // When you finish the game this appears

                System.out.println("You have finished the game with " + money + " gold. Well done!");
                break;

            }

            System.out.println("You are currently in " + towns[currentTown]);

            System.out.println("\n\t# Your health is at " + health); // General text pop up
            System.out.println("\t# You have " + money + " gold");
            System.out.println("\t# You have " + notoriety + "% notoriety");
            System.out.println("\t# You have " + strength + " strength");
            System.out.println("\t\nWhat would you like to do?");
            System.out.println("\t1. Browse the shop");
            System.out.println("\t2. Enter barbershop");
            System.out.println("\t3. Rob bank");
            System.out.println("\t4. Rob someone");
            System.out.println("\t5. Browse the stables");
            System.out.println("\t6. Travel to the next town\n");

            String input = in.nextLine(); //                    GETTING INPUT FROM THE USER

            if (input.equals("1")) { // Main screen input 1

                System.out.println("\tYou enter a goods store in town.\n");
                System.out.println("\tShopkeeper: Welcome, would you like to purchase?\n");

                System.out.println("\t# 1. Revolver - 20 gold\n\t# 2. Shotgun - 40 gold\n\t# 3. Mask - 5 gold\n\t# 4. Clothes - 10 gold\n\t# 5. Boat - 200 gold\n\t# 6. Exit");

                String inputShop = in.nextLine(); //                    GETTING INPUT FROM THE USER

                if (inputShop.equals("1")){ // SHOP INPUT 1

                    if (money >= 20) {
                        money -= 20;
                        System.out.println("\nYou bought a revolver (strength increased to 5)\n");
                        strength = 5;
                    } else System.out.println("\nYou cannot afford a revolver");

                } else if (inputShop.equals("2")){ // SHOP INPUT 2

                    if (money >= 40) {
                        money -= 40;
                        System.out.println("\nYou bought a shotgun (strength increased to 8\n");
                        strength = 8;
                    } else System.out.println("\nYou cannot afford a shotgun");

                } else if (inputShop.equals("3")) {

                    if (money >= 5) {
                        if (mask == false) {
                            money -= 5;
                            System.out.println("\nYou have bought a mask (this will hide your identity when commiting crimes)");
                            mask = true;
                        } else System.out.println("\n\tYou already own a mast.\n");
                    } else System.out.println("\nYou cannot afford a mask");

                } else if (inputShop.equals("4")) { // SHOP INPUT 3

                    if (money >= 10) {
                        if (freshClothes == false) {
                            money -= 10;
                            System.out.println("\nYou have bought a fresh set of clothes. ( - 40% notoriety)\n");
                            notoriety = notoriety - 40;
                            freshClothes = true;
                        } else System.out.println("\n\tYou have already bought clothes in this town.\n");
                    } else System.out.println("\nYou cannot afford clothes");

                } else if (inputShop.equals("5")) {

                    if (money >= 200) {
                        money -= 200;
                        System.out.println("\nCongratulations you have escaped the law!\n You escaped with " + money + " gold");
                        System.exit(0);
                    } else System.out.println("\nYou cannot afford a boat");
                }

                else System.out.println("\t\tinput not recognised please type '1' or '2'\n");


            } else if (input.equals("2")) {

                System.out.println("\nWelcome to my Barbershop\n\n\tBarber: Would you like a trim?\n");
                System.out.println("\t# 1. Get a hair cut - 20 gold\n\t# 2. Go back\n");

                String inputStable = in.nextLine(); //                    GETTING INPUT FROM THE USER

                if (inputStable.equals("1")){ // Barber shop INPUT

                    if (haircut == false) {
                        System.out.println("\tYou have got a hair cut ( - 60% notoriety)\n");
                        notoriety = notoriety - 60;
                        money = money - 20;
                        haircut = true;
                    } else System.out.println("\n\tYour hair is not long enough, try travelling.\n");

                }

            } else if(input.equals("3")){ // Main screen input 2

                int outcome = rand.nextInt(10);

                if (outcome >= 6) {

                    System.out.println("\tYou were caught robbing the bank! ( - 40 health)\n");
                    health = health - 40;

                } else if (outcome < 6){

                    System.out.println("\nYou robbed the bank! ( + 60 gold & + 70 notoriety)\n");
                    money = money + 60;
                    notoriety = notoriety + 70;

                }


            } else if (input.equals("4")){ // Main screen input 2

                int outcome = rand.nextInt(10);

                if (outcome >= 8) {

                    System.out.println("\tYou were caught robbing the someone! ( - 20 health)\n");
                    health = health - 10;

                } else if (outcome < 8){

                    System.out.println("\nYou robbed someone! ( + 15 gold & + 40 notoriety)\n");
                    money = money + 15;
                    notoriety = notoriety + 40;

                }


            } else if (input.equals("5")){ // Main screen input 2

                System.out.println("\tStablemaster: Welcome sir would you like to buy a horse?\n");
                System.out.println("\t# 1. Purchase stallion - 50 gold\n\t# 2. Go back\n");

                String inputStable = in.nextLine(); //                    GETTING INPUT FROM THE USER

                if (inputStable.equals("1")){ // HORSE STABLES INPUT

                    System.out.println("\tYou have purchased a stallion! (You are now able to travel)\n");
                    money = money - 50;
                    playerOwnsHorse = true;

                }


            } else if(input.equals("6")){ // Main screen input 2

                if(playerOwnsHorse) {

                    System.out.println("\n\tYou start your journey to the next town...\n\tYour hair grows\n");
                    currentTown = currentTown + 1;
                    freshClothes = false;
                    haircut = false;

                } else System.out.println("\tYou have to own a horse to travel. (go to the stables to buy one)\n");


            } else System.out.println("\t\tinput not recognised please type '1' or '2'\n");

        }

    }

}
