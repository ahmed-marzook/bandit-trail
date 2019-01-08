
import java.util.Scanner;

public class Game {
    String myWeapon = "N/A", playerName;
    int myHealth = 100, gold = 100, ammo = 0, notoriety = 0, choice;
    Scanner myScanner = new Scanner(System.in), enterScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.playerSetUp();
        game.firstTown();
    }
    public void playerSetUp() {
        System.out.println("Please enter your name: ");
        playerName = myScanner.nextLine();
        playerStats();
    }

    public void playerStats(){
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println(playerName + " stats are:");
        System.out.println("Health: " + myHealth);
        System.out.println("Gold: " + gold);
        System.out.println("Weapon: " + myWeapon);
        System.out.println("Ammo: " + ammo);
        System.out.println("Notoriety: " + notoriety + "%");

    }

    public void firstTown(){
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("You have just been released from jail, with just a bit of gold to your name and you head into town.\nWhat would you like to do?\n");
        System.out.println("1) Go to the Shop");
        System.out.println("2) Go to another town");
        System.out.println("3) Attempt to rob someone");
        System.out.println("4) Show player stats");

        choice = myScanner.nextInt();

        if (choice == 1){
            shop();
        }
        if (choice == 2){
            System.out.println("You got to another town");
        }
        if (choice == 3){
            robbery();
        }
        if (choice == 4) {
            playerStats();
            firstTown();
        }
    }

    public void shop() {
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("Welcome to the shop please select an item you want to buy.");
        System.out.println("1) Rifle     40G");
        System.out.println("2) Revolver  10G");
        System.out.println("3) Ammo       1G");
        System.out.println("4) Go back to the town");

        choice = myScanner.nextInt();

        if (choice == 1) {
            gold = gold - 40;
            myWeapon = "Rifle";
            System.out.println("Your Weapon is now a Rifle.\n(-40G from player inventory)");
            shop();
        }
        if (choice == 2) {
            gold = gold - 10;
            myWeapon = "Revolver";
            System.out.println("Your Weapon is now a Revolver.\n(-10G from player inventory)");
            shop();
        }
        if (choice == 3) {
            System.out.println("How much ammo do you want: ");
            choice = myScanner.nextInt();
            ammo = ammo + choice;
            gold = gold - choice;
            System.out.println("You now have " + ammo + " ammo\n(-" + choice + "G from player inventory");
            shop();
        }
        if (choice == 4) {
            firstTown();
        }
    }

    public void robbery() {
        if(myWeapon == "N/A"){
            myHealth = myHealth - 10;
            System.out.println("You attempt to rob someone but due to not having a weapon you lose.\n(-10 Health)");
            enterScanner.nextLine();
            firstTown();
        } else if(myWeapon != "N/A"){
            gold = gold + 10;
            System.out.println("You successfully rob someone gaining some gold as well as not using any ammo.\n (+10G)");
            enterScanner.nextLine();
            firstTown();
        }

    }
}
