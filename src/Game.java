//Importing utilities to my class to be able to use it
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        //initialized Variables
        String myWeapon = "N/A", playerName;
        int myHealth = 100, gold = 100, ammo = 0, notoriety = 0;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please Enter your name: ");
        playerName = myScanner.nextLine();
        System.out.println(playerName);
        //Intro Text
        System.out.println("You have just been released from jail, with just " + gold + " gold to your name you head into town, what would you like to do?");
        System.out.println("Your current stats are:");
        System.out.println("Health: " + myHealth);
        System.out.println("Gold: " + gold);
        System.out.println("Weapon: " + myWeapon);
        System.out.println("Ammo: " + ammo);
        System.out.println("Notoriety: " + notoriety + "%");


    }
}
