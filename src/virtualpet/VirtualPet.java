/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        //Splash screen
        System.out.println("                       _____^__");
        System.out.println("                      |    |   \\");
        System.out.println("                      \\   /  ^ |");
        System.out.println("                     / \\_/   0  \\");
        System.out.println("                    /            \\");
        System.out.println("   _____ _         /    ____      0   _   ");
        System.out.println("  / ____(_)       /      /  \\___ _/  | |  ");
        System.out.println(" | (___  _ _ __ ___  _   _ _ __   ___| |_");
        System.out.println("  \\___ \\| | '_ ` _ \\| | | | '_ \\ / _ \\ __|");
        System.out.println("  ____) | | | | | | | |_| | |_) |  __/ |_ ");
        System.out.println(" |_____/|_|_| |_| |_|\\__,_| .__/ \\___|\\__|");
        System.out.println("                          | |             ");
        System.out.println("                          |_|             ");
        System.out.println(" By: Nima Bakhshaie\n\n");
        
        //Login page
        System.out.println("__________________LOGIN__________________");
        System.out.print("Username: ");
        String username = kb.nextLine().toLowerCase();
        System.out.print("Password: ");
        String password = kb.nextLine().toLowerCase();
        
        if (username.equals("snoopy") && password.equals("toto")) {
            //Main menu and options
            System.out.println("________________MAIN MENU________________");
            System.out.println("1. Start");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");

            String menuChoice = kb.nextLine().toLowerCase();

            switch (menuChoice) {
                //Start menu
                case "1":
                case "start":
                    System.out.println("\n\n__________________START__________________");
                    System.out.println("1. Dog");
                    System.out.println("2. Fish");
                    String animalChoice = kb.nextLine().toLowerCase();

                    switch (animalChoice) {
                        case "1":
                        case "dog":
                            System.out.println("\n\nSELECTED: DOG");
                            break;
                        case "2":
                        case "fish":
                            System.out.println("\n\nSELECTED: FISH");
                            break;
                    }
                    break;
                //Instruction menu
                case "2":
                case "instructions":
                    System.out.println("\n\n_______________INSTRUCTIONS_______________");
                    break;
                //Exit program
                case "3":
                case "exit":
                    System.out.println("\n\n...EXITING...");
                    System.exit(0);
                    break;
        }
    }
        else {
            System.out.println("WRONG USERNAME/PASSWORD");
            System.out.println("...EXITING PROGRAM...");
            System.exit(0);
        }
    }
}
