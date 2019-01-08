import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Player variables
        int health = 100;
        int money = 50;

        boolean running = true;

        System.out.println("Welcome to the city of Valentine");

        GAME:
        while(running){

            System.out.println("\t# Your health is at " + health);
            System.out.println("\t# You have " + money + " gold");
            System.out.println("\t\nWhat would you like to do?");
            System.out.println("\t1. Rob bank");
            System.out.println("\t2. Rob someone\n");

            String input = in.nextLine();

            if (input.equals("1")){

                int outcome = rand.nextInt(10);

                if (outcome >= 6) {

                    System.out.println("\tYou were caught robbing the bank! (You lose 20 health)");
                    health = health - 20;

                }else if (outcome < 6){

                    System.out.println("\nYou robbed the bank! (You gained 60 gold.)\n");
                    money = money + 60;

                }


            } else if (input.equals("2")){

                int outcome = rand.nextInt(10);

                if (outcome >= 8) {

                    System.out.println("\tYou were caught robbing the someone! (You lose 10 health)");
                    health = health - 10;

                }else if (outcome < 8){

                    System.out.println("\nYou robbed someone! (You gained 15 gold.)\n");
                    money = money + 15;

                }


            } else System.out.println("input not recognised please type '1' or '2'");

        }

    }

}
