
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // to get user's weight 
        System.out.print("Enter your weight (in kilograms): ");
        double weight = scanner.nextDouble();

        // to get user's height 
        System.out.print("Enter your height (in meters): ");
        double height = scanner.nextDouble();

        // to calculate BMI
        double bmi = calBMI(weight, height);

        // to determine the health category
        String healthCategory = dethelcat(bmi);

        // to display the calculated BMI and health category
        System.out.printf("Your BMI is: %.2f%n", bmi);
        System.out.println("Your Health Category is: " + healthCategory);

        scanner.close();
    }

    //for BMI calculation [formula: weight/(height^2)]
    static double calBMI(double weight, double height) {
        return weight / (height * height);
    }

    //for determination of BMI after the BMI calculation
    static String dethelcat(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obessity";
        }
    }
}
