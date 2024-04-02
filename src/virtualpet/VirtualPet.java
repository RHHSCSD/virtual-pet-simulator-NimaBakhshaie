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
        Random r = new Random();
        
        final String CORRECT_USERNAME = "snoopy";
        final String CORRECT_PASSWORD = "toto";
        final String CONSONANT_LIST = "BCDFGHJKLMNPRSTVWYZ";
        final String VOWEL_LIST = "AEIOU";
        
        String username = "";
        String password = "";
        
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
        
        //Login page (with 3 attempts)
        for (int i = 0; i < 3 &&  !(username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)); i++) {
            if (i > 0) {
                System.out.println("Wrong password/username entered. You have " + (3 - i) + " attempt(s) remaining.");
            }
            System.out.println("__________________LOGIN__________________");
            System.out.print("Username: ");
            username = kb.nextLine().toLowerCase();
            System.out.print("Password: ");
            password = kb.nextLine().toLowerCase();
        }
        
        //If correct username and password
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            //Main menu and options
            System.out.println("________________MAIN MENU________________");
            System.out.println("1. Start");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");

            String menuChoice = kb.nextLine().toLowerCase();

            switch (menuChoice) {
                //if start menu is user's choice
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
                            //Choice of Rock
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
                    //Naming prompt for naming pet
                    System.out.println("\n\n__________________NAME__________________");
                    System.out.println("Would you like to name your Simupet? Selecting no will result in a randomized name. (y/n)");
                    String namingChoice = kb.nextLine().toLowerCase();

                    if (namingChoice.equals("y")) { //if user chooses to name the pet themselves
                        System.out.println("What would you like to name it?");
                        petName = kb.nextLine().toUpperCase();
                    } else if (namingChoice.equals("n")) { //Generating a random name if user doesn't want to name pet
                        int numOfLetters = r.nextInt(4) + 4;
                        
                        int consonantPosition = r.nextInt(CONSONANT_LIST.length());
                        char consonantUsed = CONSONANT_LIST.charAt(consonantPosition);
                        int vowelPosition = r.nextInt(VOWEL_LIST.length());
                        char vowelUsed = VOWEL_LIST.charAt(vowelPosition);
                        
                        double isDoubleVowel = Math.random();

                        for (int i = 0; i < numOfLetters; i++) {
                            if (i == 0) {
                                petName = petName + consonantUsed;
                            }
                            else if (i % 2 == 0) {
                                consonantPosition = r.nextInt(CONSONANT_LIST.length());
                                consonantUsed = CONSONANT_LIST.charAt(consonantPosition);
                                petName = petName + consonantUsed;
                                
                            } else {
                                vowelPosition = r.nextInt(VOWEL_LIST.length());
                                vowelUsed = VOWEL_LIST.charAt(vowelPosition);
                                petName = petName + vowelUsed;
                                
                                if (isDoubleVowel > 0.8) {
                                    petName = petName + vowelUsed;
                                }
                             isDoubleVowel = Math.random();
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
            System.out.println("TOO MANY WRONG ATTEMPTS TO LOG IN");
            System.out.println("...EXITING PROGRAM...");
            System.exit(0);
        }
    }
}
