import java.util.Scanner;

public class BMICalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Select an option:\n0 - Imperial\n1 - Metric");
		int isMetric = scanner.nextInt();
		
		float weight, height;
		
		System.out.println("Enter weight");
		weight = scanner.nextFloat();
		System.out.println("Enter height");
		height = scanner.nextFloat();
		
		float bmi = ((isMetric == 1 ? 1 : 703) * weight) / (height * height);
		System.out.println(""+bmi);
		System.out.println("BMI Categories:\r\n" + 
				"Underweight = <18.5\r\n" + 
				"Normal weight = 18.5–24.9\r\n" + 
				"Overweight = 25–29.9\r\n" + 
				"Obesity = BMI of 30 or greater");
	}
}
