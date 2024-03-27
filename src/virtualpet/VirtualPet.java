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
        final String CONSONANT_LIST = "BCDFGHJKLMNPRSTVWYZ";
        final String VOWEL_LIST = "AEIOU";
        
        String petName = "";
        
        int statsPointsTotal = 100;
        int maxFood = 0;
        int maxHealth = 0;
        int maxEnergy = 0;
        int currentFood = 0;
        int currentHealth = 0;
        int currentEnergy = 0;
        
        
        
        
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
                    System.out.println("2. Rock");
                    String animalChoice = kb.nextLine().toLowerCase();

                    switch (animalChoice) {
                        case "1":
                        case "dog":
                            //Choice of Dog
                            System.out.println("\n\nSELECTED: DOG");
                            
                            maxEnergy = r.nextInt(10) + 21;
                            maxFood = r.nextInt(10) + 21;
                            maxHealth = r.nextInt(10) + 21;
                            
                            maxEnergy += statsPointsTotal - maxEnergy - maxFood - maxHealth;
                            
                            currentEnergy = maxEnergy;
                            currentFood = maxFood;
                            currentHealth = maxHealth;
                            
                            break;
                        case "2":
                        case "rock":
                            //Choice of Fish
                            System.out.println("\n\nSELECTED: ROCK");
                            
                            maxEnergy = r.nextInt(10) + 21;
                            maxFood = r.nextInt(10) + 21;
                            maxHealth = r.nextInt(10) + 21;
                            
                            maxHealth += statsPointsTotal - maxEnergy - maxFood - maxHealth;
                            
                            currentEnergy = maxEnergy;
                            currentFood = maxFood;
                            currentHealth = maxHealth;
                            
                            break;
                    }
                    System.out.println("\n\n__________________NAME__________________");
                    System.out.println("Would you like to name your Simupet? Selecting no will result in a randomized name. (y/n)");
                    String namingChoice = kb.nextLine().toLowerCase();

                    if (namingChoice.equals("y")) {
                        System.out.println("What would you like to name it?");
                        petName = kb.nextLine().toUpperCase();
                    } else if (namingChoice.equals("n")) {
                        int numOfLetters = (r.nextInt(3) + 1) * 2 + 2;
                        
                        int consonantPosition = r.nextInt(CONSONANT_LIST.length());
                        char consonantUsed = CONSONANT_LIST.charAt(consonantPosition);
                        int vowelPosition = r.nextInt(VOWEL_LIST.length());
                        char vowelUsed = VOWEL_LIST.charAt(vowelPosition);
                        
                        double isDoubleVowel = Math.random();
                        //double vowel randomly? What about name length? 6 char name?

                        for (int i = 0; i < numOfLetters; i++) {
                            if (i == 0) {
                                petName = petName + consonantUsed;
                            }
                            else if (i % 2 == 0) {
                                petName = petName + consonantUsed;
                                
                            } else {
                                petName = petName + vowelUsed;
                            }
                        }
                    }
                    
                    System.out.println("\n***Your Simupet, named " + petName + ", has been born!***\n");
                    
                    System.out.println("__________________HOME__________________");
                    System.out.println("STATUS of " + petName + ":");
                    System.out.println("Health: " + currentHealth + "/" + maxHealth);
                    System.out.println("Energy: " + currentEnergy + "/" + maxEnergy);
                    System.out.println("Food: " + currentFood + "/" + maxFood);
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
