

import java.util.Scanner;
import lindsey_p1.Encrypter;
import lindsey_p1.Decrypter;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Get user input
		System.out.println("Select an option:\n0 - Encrypt\n1 - Decrypt");
		int input = scanner.nextInt();
		System.out.println("Enter number");
		int input2 = scanner.nextInt();
		
		scanner.close();
		
		if(input == 0) {
			// Encrypt
			int encrypted = Encrypter.encrypt(input2);
			if(encrypted < 1000) {
				System.out.print("0" + encrypted);
			} else {
				System.out.print(encrypted);
			}
		} else if(input == 1) {
			// Decrypt
			int decrypted = Decrypter.decrypt(input2);
			System.out.println(decrypted);
		} else {
			System.out.println("Try again please.");
		}
	}
}
