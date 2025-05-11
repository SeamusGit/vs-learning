package com.study;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        while (true) {
        	 System.out.println("\n===== Number Guessing Game =====");
             System.out.println("Select Difficulty Level:");
             System.out.println("1. Easy (Unlimited attempts)");
             System.out.println("2. Medium (10 attempts)");
             System.out.println("3. Hard (5 attempts)");
             System.out.print("Enter choice (1-3): ");
             
             int maxAttempts = getDifficulty(sc);
             int lowerBound = 1;
             int upperBound = 100;
             int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
             int attempts = 0;
             boolean guessedCorrectly = false;
             
             System.out.println("\nI have picked a number between " + lowerBound + " and " + upperBound + ".");
             System.out.println("Can you guess it?");
             
             while (maxAttempts == -1 || attempts < maxAttempts) {
            	 int userGuess = getValidNumber(sc, lowerBound, upperBound);
            	 attempts++;
            	 
            	 if (userGuess == targetNumber) {
            		 System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                     guessedCorrectly = true;
                     break;
            	 } else if (userGuess < targetNumber) {
                     System.out.println("Too low! Try again.");
                 } else {
                     System.out.println("Too high! Try again.");
                 }
            	 
            	 provideHint(userGuess, targetNumber);
             }
             
             if (!guessedCorrectly) {
            	 System.out.printf("Game Over! The target number was %d!%n", targetNumber);
             }
             
             System.out.print("\nPLAY AGAIN? (yes/no): ");
             if (!sc.next().equalsIgnoreCase("yes")) {
            	 break;
             }
        }
        
	}
	
	private static int getDifficulty(Scanner sc) {
		while (true) {
			if (sc.hasNextInt()) {
				int choice = sc.nextInt();
                switch (choice) {
                    case 1: return -1; // Easy mode (unlimited attempts)
                    case 2: return 10; // Medium mode
                    case 3: return 5;  // Hard mode
                    default: System.out.print("⚠️ Invalid choice. Enter 1, 2, or 3: ");
			}
		} else {
			System.out.print("Invalid Option. Enter a number (1-3): ");
			sc.next();
			}
		}
	}
	
	private static int getValidNumber(Scanner sc, int lowerBound, int upperBound) {
		while (true) {
			System.out.print("Your Guess: ");
			if (sc.hasNextInt()) {
				int userGuess = sc.nextInt();
				if (userGuess >= lowerBound && userGuess <= upperBound) {
					return userGuess;
				}
				System.out.println("Please enter a number between " + lowerBound + "and " + upperBound + ".");
			} else {
				System.out.println("Invalid input. Please enter a valid number.");
				sc.next();
			}	
		} 
	}
	
	private static void provideHint(int userGuess, int targetNumber) {
		int difference = Math.abs(userGuess-targetNumber);
		if (difference <= 5) {
			System.out.println("You're getting close!!!");
		} else if (difference <= 10){
			System.out.println("Within 10!");
		}
		
	}
	
	
	
	
	
}
