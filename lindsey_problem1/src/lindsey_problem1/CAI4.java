package lindsey_problem1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;


public class CAI4 {
	static SecureRandom rand;
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		while(true) {
			quiz();
		}
	}
	
	static void quiz() throws NoSuchAlgorithmException {
		// Initialize generator
		rand = SecureRandom.getInstance("SHA1PRNG");
		
		// Prompt for difficulty
		int difficulty = readDifficulty();
		
		// Start question loop
		int wrongCount = 0;
		for(int i=0; i<10; i++) {
			// Generate random numbers
			int num1, num2;
			num1 = Math.abs(rand.nextInt() % (int)Math.pow(10, difficulty));
			num2 = Math.abs(rand.nextInt() % (int)Math.pow(10, difficulty));
			
			// Ask question
			askQuestion(num1, num2);
			
			// Process input
			int input = readResponse();
			if(isAnswerCorrect(input, num1, num2)) {
				displayCorrectResponse();
			} else {
				wrongCount++;
				displayIncorrectResponse();
			}
		}
		
		// Calculate score, display end message
		float percScore = ((float)(10 - wrongCount) / 10f) * 100f;
		
		System.out.println("Score: " + percScore + "%");
		if(percScore >= 75) {
			System.out.println("\nCongratulations, you are ready to go to the next level!\n");
		} else {
			System.out.println("\nPlease ask your teacher for extra help.\n");
		}
	}
	
	static void askQuestion(int num1, int num2) {
		System.out.println("How much is " + num1 + " times " + num2 + "?");
	}
	
	static int readResponse() {
		Scanner scan = new Scanner(System.in);
		System.out.print("> ");
		int input = scan.nextInt();
		return input;
	}
	
	static int readDifficulty() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Choose difficulty (1-4)\n> ");
		int input = scan.nextInt();
		return input;
	}
	
	static boolean isAnswerCorrect(int ans, int num1, int num2) {
		if(ans == num1 * num2) {
			return true;
		} else {
			return false;
		}
	}
	
	static void displayCorrectResponse() {
		int r = rand.nextInt(5);
		
		switch(r) {
		case 0:
			System.out.println("Very Good!");
			break;
		case 1:
			System.out.println("Excellent!");
			break;
		case 2:
			System.out.println("Nice Work!");
			break;
		case 3:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	static void displayIncorrectResponse() {
		int r = rand.nextInt(5);
		
		switch(r) {
		case 0:
			System.out.println("No. Please try again.");
			break;
		case 1:
			System.out.println("Wrong. Try once more.");
			break;
		case 2:
			System.out.println("Don't give up!");
			break;
		case 3:
			System.out.println("No. Keep trying.");
			break;
		}
	}
}