import java.util.Scanner;

public class Main extends Town{

    public static void main(String[] args){

        boolean running = true;

        Main x = new Main();
        Town town = new Town();
        Scanner in = new Scanner(System.in);

        System.out.println("\n\n\t\t\t\t----------------------------");
        System.out.println("\t\t\t\t|  B a n d i t  T r a i l  |");
        System.out.println("\t\t\t\t----------------------------");

        x.pause(2000);
        System.out.println("\n\n\nYour journey starts here.\n(Type your name then press enter)\n");
        String name = in.nextLine();
        x.pause(200);
        System.out.println("\nHello " + name + ", good luck.\n\n\n\n");

        x.pause(400);
        System.out.println("\t ===========================& &===========================");
        System.out.println("\t\tYou have just been released from jail, " +
                "\n\t\twith just 50 gold to your name you head into town...");
        System.out.println("\t =========================================================\n\n\n");

        while(running){

            x.pause(200);
            town.displayOptions();
            x.pause(700);
            town.pickOption();
            x.pause(200);

        }

    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }



}
