package lindsey_problem1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;


public class CAI5 {
	static SecureRandom rand;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		while(true) {
			quiz();
		}
	}
	
	static void quiz() throws NoSuchAlgorithmException {
		// Initialize generator
		rand = SecureRandom.getInstance("SHA1PRNG");
		
		// Prompt for parameters
		int difficulty = readDifficulty();
		int operator = readOperator();
		boolean mix = false;
		if(operator == 5) {
			operator = rand.nextInt(5);
			mix = true;
		}
		
		// Start question loop
		int wrongCount = 0;
		for(int i=0; i<10; i++) {
			// Generate random numbers
			if(mix) operator = rand.nextInt(5);
			double num1, num2;
			num1 = Math.abs(rand.nextInt() % (int)Math.pow(10, difficulty));
			do {
				num2 = Math.abs(rand.nextInt() % (int)Math.pow(10, difficulty));
			} while(operator == 4 && num2 == 0);
			
			// Ask question
			askQuestion((int)num1, (int)num2, operator);
			
			// Process input
			double input = readResponse();
			if(isAnswerCorrect(input, num1, num2, operator)) {
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
	
	static void askQuestion(int num1, int num2, int operator) {
		switch(operator) {
			case 1:
				System.out.println("How much is " + num1 + " plus " + num2 + "?");
				break;
			case 2:
				System.out.println("How much is " + num1 + " times " + num2 + "?");
				break;
			case 3:
				System.out.println("How much is " + num1 + " minus " + num2 + "?");
				break;
			case 4:
				System.out.println("How much is " + num1 + " divided by " + num2 + "?");
				break;
		}
	}
	
	static double readResponse() {
		System.out.print("> ");
		double input = scan.nextDouble();
		return input;
	}
	
	static int readDifficulty() {
		System.out.print("Choose difficulty (1-4)\n> ");
		int input = scan.nextInt();
		if(input < 1 || input > 4) input = 2;
		return input;
	}
	
	static int readOperator() {
		System.out.print("Choose problem type:\n1 - Addition\n2 - Multiplication\n3 - Subtraction\n4 - Division\n5 - Mix\n> ");
		int input = scan.nextInt();
		if(input < 1 || input > 5) input = 2;
		return input;
	}
	
	static boolean isAnswerCorrect(double ans, double num1, double num2, int operator) {
		boolean isCorrect = false;
		
		switch(operator) {
		case 1:
			isCorrect = (ans == num1 + num2);
			break;
		case 2:
			isCorrect = (ans == num1 * num2);
			break;
		case 3:
			isCorrect = (ans == num1 - num2);
			break;
		case 4:
			isCorrect = (ans == num1 / num2);
		}
		
		return isCorrect;
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