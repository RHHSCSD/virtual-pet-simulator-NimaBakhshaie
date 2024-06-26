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
    
    //declaring public final values
    public static final String CORRECT_USERNAME = "snoopy";
    public static final String CORRECT_PASSWORD = "toto";
    public static final String CONSONANT_LIST = "BCDFGHJKLMNPRSTVWYZ";
    public static final String VOWEL_LIST = "AEIOU";
    
    //Initializing variables
    public static String username = "";
    public static String password = "";

    public static String petName = "";

    public static int statsPointsTotal = 100;
    public static int maxFood = 0;
    public static int maxHealth = 0;
    public static int maxEnergy = 0;
    public static int currentFood = 0;
    public static int currentHealth = 0;
    public static int currentEnergy = 0;
    public static int cash = 0;
        
        
        
        
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        
        //Print splash screen
        splashScreen();
        
        //Login page with 3 attemps. loginPage returns true if the username and password are correct
        boolean loginPageResults = loginPage();
        
        //If correct username and password
        if (loginPageResults) {
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
                    
                    //The switch statement below generataes stats based on the player choice of pet
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

                    petName = petNamer();
                    
                    System.out.println("\n***Your Simupet, named " + petName + ", has been born!***\n");
                    
                    printStats();
                    
                    while (true) {
                        System.out.println("\n\n__________________HOME__________________");
                        System.out.println("1. Play");
                        System.out.println("2. Instructions");
                        System.out.println("3. Exit");
                        
                        String menuOption = kb.nextLine().toLowerCase();
                        switch (menuOption) {
                            case "1":
                            case "play":
                                System.out.println("\n__________________PLAY__________________");
                                System.out.println("1. Pet");
                                System.out.println("2. Games");
                                
                                String playMenuOption = kb.nextLine().toLowerCase();
                                
                                switch (playMenuOption) {
                                    case "2":
                                    case "games":
                                        System.out.println("\n__________________GAMES__________________");
                                        System.out.println("1. Guess My Number");
                                        System.out.println("2. Matching Game");
                                        
                                        String gamesMenuOption = kb.nextLine().toLowerCase();
                                        
                                        switch (gamesMenuOption) {
                                            case "1":
                                            case "guess my number":
                                                guessMyNumber();
                                                break;
                                            case "2":
                                            case "matching game":
                                                String deck = "AABBCCDDEE";
                                                String shuffledDeck = "";
                                                
                                                for (int i = 0; i < 10; i++) {
                                                    int randomCutNumber = r.nextInt(10-i);
                                                    shuffledDeck += deck.charAt(randomCutNumber);
                                                    deck = deck.substring(0, randomCutNumber) + deck.substring(randomCutNumber + 1);
                                                }
                                                
                                                deck = shuffledDeck;
                                                System.out.println(shuffledDeck);
                                                
                                                int wrongGuesses = 0;
                                                String hiddenDeck = "XXXXXXXXXX";
                                                int cashEarned = 10;
                                                int numberOfGuesses = 0;
                                                int correctLetters = 0;
                                                while (wrongGuesses < 5) {
                                                    System.out.println("You have " + (5-wrongGuesses) + " wrong guesses left");
                                                    System.out.println(hiddenDeck);
                                                    System.out.print("Guess: ");
                                                    String locationGuess = kb.nextLine().toLowerCase();
                                                    numberOfGuesses++;
                                                    
                                                    int guessIndex1 = (Math.min((int) locationGuess.charAt(0), (int) locationGuess.charAt(1))) - 48;
                                                    int guessIndex2 = (Math.max((int) locationGuess.charAt(0), (int) locationGuess.charAt(1))) - 48;
                                                    
                                                    if (deck.charAt(guessIndex1) == deck.charAt(guessIndex2)) {
                                                        System.out.println("Correct match!");
                                                        hiddenDeck = hiddenDeck.substring(0, guessIndex1) + deck.charAt(guessIndex1) + hiddenDeck.substring(guessIndex1 + 1, guessIndex2) + deck.charAt(guessIndex2) + hiddenDeck.substring(guessIndex2 + 1);
                                                        correctLetters += 1;
                                                        cashEarned += 4;
                                                    } else if (deck.charAt(guessIndex1) != deck.charAt(guessIndex2) && wrongGuesses < 4){
                                                        System.out.println("Try again");
                                                        wrongGuesses ++;
                                                        cashEarned -= 2;
                                                    } else {
                                                        System.out.println("Game over! You lost!");
                                                        wrongGuesses++;
                                                    }
                                                    
                                                    if (correctLetters == 5 && wrongGuesses < 5) {
                                                        System.out.println("Good job! You won $" + cashEarned + "!");
                                                        System.out.println("It took you " + numberOfGuesses + " guesses to win");
                                                        cash += cashEarned;
                                                        wrongGuesses = 5;
                                                    }
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "3":
                            case "exit":
                                System.out.println("...EXITING PROGRAM...");
                                System.exit(0);

                        }
                    }
                    
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
    
    public static boolean loginPage() {
        //Creating new scanner
        Scanner kb = new Scanner(System.in);
        
        //Creating username and password variables
        String username = "";
        String password = "";
        
        //For loop gives 3 attemps to get the right username and password
        for (int i = 0; i < 3 &&  !(username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)); i++) {
            //While the user isn't out of attempts, tell them how many they have left
            if (i > 0) {
                System.out.println("Wrong password/username entered. You have " + (3 - i) + " attempt(s) remaining.");
            }
            //Print login screen and ask for username and password
            System.out.println("__________________LOGIN__________________");
            System.out.print("Username: ");
            username = kb.nextLine().toLowerCase();
            System.out.print("Password: ");
            password = kb.nextLine().toLowerCase();
        }
        
        //If the user enters the right username and password, then return true
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String petNamer() {
        //Defining petname
        String petName = "";
        
        //Creating new scanner and random
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        
        //Naming prompt for naming pet
        System.out.println("\n\n__________________NAME__________________");
        System.out.println("Would you like to name your Simupet? Selecting no will result in a randomized name. (y/n)");
        String namingChoice = kb.nextLine().toLowerCase();
        
        if (namingChoice.equals("y")) { //if user chooses to name the pet themselves
            System.out.println("What would you like to name it?");
            petName = kb.nextLine().toUpperCase();
        } else { //Generating a random name if user doesn't want to name pet
            //Generating a random number between 4 and 8
            int numOfLetters = r.nextInt(4) + 4;
            
            //Pick out a random consonant to be used as first letter
            int consonantPosition = r.nextInt(CONSONANT_LIST.length());
            char consonantUsed = CONSONANT_LIST.charAt(consonantPosition);
            
            //Define vowel selectors
            int vowelPosition;
            char vowelUsed;
          
            
            //Roll random to see if a double vowel will be used
            double isDoubleVowel = Math.random();
            
            //Loop for every letter
            for (int i = 0; i < numOfLetters; i++) {
                //If its the first letter, use a consonant
                if (i == 0) {
                    petName = petName + consonantUsed;
                }
                //The code below alternates between random consonants and vowels to create a proper name
                else if (i % 2 == 0) {
                    //Get a random consonant
                    consonantPosition = r.nextInt(CONSONANT_LIST.length());
                    consonantUsed = CONSONANT_LIST.charAt(consonantPosition);
                    //Add consonant to petname
                    petName = petName + consonantUsed;

                } else {
                    //Get a random vowel
                    vowelPosition = r.nextInt(VOWEL_LIST.length());
                    vowelUsed = VOWEL_LIST.charAt(vowelPosition);
                    //add to pet name
                    petName = petName + vowelUsed;
                    
                    //Randomly adds double vowels every once in a while (20% chance)
                    if (isDoubleVowel > 0.8) {
                        petName = petName + vowelUsed;
                    }
                 //Reroll double vowel
                 isDoubleVowel = Math.random();
                }
            }
        }
        
        return petName;
    }
    
    public static void printStats() {
        System.out.println("STATS:");
        System.out.println("Health: " + currentHealth + "/" + maxHealth);
        System.out.println("Energy: " + currentEnergy + "/" + maxEnergy);
        System.out.println("Food: " + currentFood + "/" + maxFood);
    }
    
    public static void splashScreen() {
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
    }
    
    public static void guessMyNumber() {
        Random r = new Random();
        Scanner kb = new Scanner(System.in);
        
        int selectedNumber = r.nextInt(100) + 1;
        System.out.println("\nGuess my number between 1 - 100");

        boolean correctGuess = false;
        int guessingPoints = 25;
        for (int i = 0; i < 5 && correctGuess == false; i++) {
            System.out.println("You have " + (5 - i) + " tries remaining");
            int numberGuess = kb.nextInt();
            String clearWhiteSpace = kb.nextLine();

            if (selectedNumber < numberGuess && i < 4) {
                System.out.println("Too High!");
                guessingPoints -= 5;
            } else if (selectedNumber > numberGuess && i < 4) {
                System.out.println("Too Low!");
                guessingPoints -= 5;
            } else if (selectedNumber == numberGuess) {
                System.out.println("That's right! You win $" + guessingPoints + "!");
                cash += guessingPoints;
                correctGuess = true;
            } else {
                System.out.println("Bad luck, my number was " + selectedNumber);
            }

        }
    }
}
