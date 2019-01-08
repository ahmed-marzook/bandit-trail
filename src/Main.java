import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("\n\n\t\t\t\t----------------------------");
        System.out.println("\t\t\t\t|  B a n d i t  T r a i l  |");
        System.out.println("\t\t\t\t----------------------------");

        System.out.println("\n\n\nYour journey starts here.\n(Type your name then press enter)\n");
        String name = in.nextLine();
        System.out.println("\nHello " + name + ", good luck.");


    }

}
