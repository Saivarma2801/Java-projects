package randam_number;


	import java.util.Scanner;
	import java.util.Random;
	
	public class Randam_Number {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Random random = new Random();

	        int roundsPlayed = 0;
	        int totalScore = 0;

	        System.out.println("Welcome to the number guessing game....");

	        boolean playAgain = true;
	        while (playAgain) {
	            System.out.println("\nStarting a new round!");
	            roundsPlayed++;

	            int generatedNumber = random.nextInt(100) + 1; 
	            int attemptsLeft = 10;
	            int roundScore = 0;

	            System.out.println("I am thinking of a number between 1 and 100.");
	            System.out.println("You have " + attemptsLeft + " attempts to guess the correct number.");

	            while (attemptsLeft > 0) {
	                System.out.print("\nEnter your guessing number : ");
	                
	                try {
	                    int guess = Integer.parseInt(sc.nextLine());

	                    if (guess < 1 || guess > 100) {
	                        System.out.println("Please guess a number between 1 and 100.");
	                        continue;
	                    }

	                    if (guess == generatedNumber) {
	                        System.out.println("Congratulations! You guessed the correct number.");
	                        roundScore = attemptsLeft * 10;
	                        totalScore += roundScore;
	                        break;
	                    } else if (guess < generatedNumber) {
	                        System.out.println("Too low! Try again.");
	                    } else {
	                        System.out.println("Too high! Try again.");
	                    }

	                    attemptsLeft--;

	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Please enter a valid number.");
	                }
	            }

	            if (attemptsLeft == 0) {
	                System.out.println("\nSorry, you're out of attempts. The number was " + generatedNumber + ".");
	            }

	            System.out.println("Your score for this round: " + roundScore);
	            System.out.println("Total score: " + totalScore);

	            System.out.print("\nDo you want to play another round? (yes/no): ");
	            String response = sc.nextLine().trim().toLowerCase();
	            playAgain = response.equals("yes");
	        }

	        System.out.println("\nThank you for playing the Number Guessing Game....");
	        System.out.println("Total rounds played: " + roundsPlayed);
	        System.out.println("Final score: " + totalScore);

	        sc.close();
	    }
	}
