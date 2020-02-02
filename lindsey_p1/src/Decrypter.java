

public class Decrypter {
	public static int decrypt(int input) {
		int num1 = input / 1000;
		int num2 = (input % 1000) / 100;
		int num3 = (input % 100) / 10;
		int num4 = input % 10;
		
		num1 = (num1 + 3) % 10;
		num2 = (num2 + 3) % 10;
		num3 = (num3 + 3) % 10;
		num4 = (num4 + 3) % 10;
		
		int output = num3 * 1000;
		output += num4 * 100;
		output += num1 * 10;
		output += num2;
		
		return output;
	}

}
