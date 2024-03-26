/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
import java.lang.Math;
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
        Random r = new Random();
        
        final String CORRECT_USERNAME = "snoopy";
        final String CORRECT_PASSWORD = "toto";
        final String CONSONANT_LIST = "bcdfghjklmnprstvwyz";
        
        
        
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
        
        //If correct username and password
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
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
                            //Choice of Dog
                            System.out.println("\n\nSELECTED: DOG");
                            System.out.println("\n\n__________________NAME__________________");
                            
                            break;
                        case "2":
                        case "rock":
                            //Choice of Fish
                            System.out.println("\n\nSELECTED: ROCK");
                            break;
                    }
                 
                    System.out.println("Would you like to name your " + animalChoice + "? (y/n)");
                    String namingChoice = kb.nextLine().toLowerCase();

                    if (namingChoice.equals("y")) {
                        System.out.println("What would you like to name it?");
                        String petName = kb.nextLine().toUpperCase();
                    } else if (namingChoice.equals("n")) {
                        int numOfLetters = r.nextInt(4) + 4;
                        String petName = "";

                        for (int i = 0; i < numOfLetters; i++) {
                            if (i == 0) {
                                char consonantUsed = CONSONANT_LIST.charAt(r.nextInt(CONSONANT_LIST.length()));
                            }
                            else if (i % 2 = 0) {
                                gkgkh
                            }
                        }
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
            //Exiting Program if password is wrong
            System.out.println("WRONG USERNAME/PASSWORD");
            System.out.println("...EXITING PROGRAM...");
            System.exit(0);
        }
    }
}
