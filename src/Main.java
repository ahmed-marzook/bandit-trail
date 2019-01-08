import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Game variables
        String[] towns = {"Valentine", "Rhodes", "Lagras"};
        int currentTown = 0;

        // Shop variables
        int amountOfSyringes = 4;

        // Player variables
        int health = 100;
        int money = 50;

        boolean running = true;


        while(running) {

            if (health <= 0) {
                System.out.println("\n\t YOU ARE DEAD");
                break;
            }

            if (currentTown >= towns.length) {

                System.out.println("You have finished the game with " + money + " gold. Well done!");
                break;

            }

            System.out.println("Welcome to the city of " + towns[currentTown]);

            System.out.println("\n\t# Your health is at " + health);
            System.out.println("\t# You have " + money + " gold");
            System.out.println("\t\nWhat would you like to do?");
            System.out.println("\t1. Browse the shop");
            System.out.println("\t2. Rob bank");
            System.out.println("\t3. Rob someone");
            System.out.println("\t4. Travel to the next town\n");

            String input = in.nextLine();

            if (input.equals("1")) {

                System.out.println("\tYou see a bottle of beer and a syringe on the shelf, it looks dirty.\n");
                System.out.println("\tShopkeeper: Welcome, would you like to purchase?\n");

                System.out.println("\t1. Beer - 5 gold\n\t2. Syringe - 15 gold");

                String inputShop = in.nextLine();

                if (inputShop.equals("1")){

                    System.out.println("\nYou bought then drank the bottle of beer. ( -5 gold and -5 health, you did have some fun though)\n");
                    money = money - 5;
                    health = health - 5;

                } else if (inputShop.equals("2")){

                    if (amountOfSyringes <= 0) {

                        System.out.println("\tShopkeeper: There are no syringes left.\n");

                    } else if (amountOfSyringes > 0) {

                        System.out.println("\nYou bought then injected yourself with the dirty syringe. ( -15 gold and +10 health)\n");
                        amountOfSyringes = amountOfSyringes - 1;
                        money = money - 15;
                        health = health + 10;

                    }

                } else System.out.println("\t\tinput not recognised please type '1' or '2'\n");


            } else if (input.equals("2")){

                int outcome = rand.nextInt(10);

                if (outcome >= 6) {

                    System.out.println("\tYou were caught robbing the bank! (You lose 20 health)\n");
                    health = health - 20;

                } else if (outcome < 6){

                    System.out.println("\nYou robbed the bank! (You gained 60 gold.)\n");
                    money = money + 60;

                }


            } else if (input.equals("3")){

                int outcome = rand.nextInt(10);

                if (outcome >= 8) {

                    System.out.println("\tYou were caught robbing the someone! (You lose 10 health)\n");
                    health = health - 10;

                } else if (outcome < 8){

                    System.out.println("\nYou robbed someone! (You gained 15 gold.)\n");
                    money = money + 15;

                }


            } else if( input.equals("4")){

                currentTown = currentTown + 1;

            } else System.out.println("\t\tinput not recognised please type '1' or '2'\n");

        }

    }

}
