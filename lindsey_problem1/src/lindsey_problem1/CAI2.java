package lindsey_problem1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	static SecureRandom rand;
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		quiz();	
	}
	
	static void quiz() throws NoSuchAlgorithmException {
		// Generating random numbers
		rand = SecureRandom.getInstance("SHA1PRNG");
		int num1, num2;
		num1 = Math.abs(rand.nextInt() % 10);
		num2 = Math.abs(rand.nextInt() % 10);
		
		askQuestion(num1, num2);
		
		// Start loop
		boolean looping = true;
		while(looping) {
			int input = readResponse();
			if(isAnswerCorrect(input, num1, num2)) {
				looping = false;
				displayCorrectResponse(); 
			} else {
				displayIncorrectResponse();
			}	
	}
		
		System.exit(0);
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