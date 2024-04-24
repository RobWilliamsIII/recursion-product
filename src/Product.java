import java.util.Scanner;

public class Product {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numberStrings;


        do {
            System.out.print("Enter five numbers separated by commas (Ex:5,4,3,2,1): ");
            String input = scanner.nextLine();

            // Split the user input into an array of strings seperated by the comma
            numberStrings = input.split(",");

            // Make sure at least 5 numbers are entered
            if (numberStrings.length < 5) {
                System.out.println("Please enter 5 numbers.");
            }
        } while (numberStrings.length < 5);

        // Convert numberStrings to a double array
        double[] numbers = new double[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Double.parseDouble(numberStrings[i].trim());
        }

        // Get the product of the numbers array
        double product = getProduct(numbers, 0);
        System.out.println("The product of the numbers is: " + product);

        scanner.close();
    }

    // Recursive method to calculate the product of the numbers
    public static double getProduct(double[] numbers, int index) {
        // Base case: If index is at the last element, return the number
        if (index == numbers.length - 1) {
            return numbers[index];
        } else {
            // Recursive case: Multiply current number with product of remaining numbers
            return numbers[index] * getProduct(numbers, index + 1);
        }
    }
}