import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Call the reverseNumber method to reverse the input number
        int reversed = reverseNumber(number);

        // Display the reversed number
        System.out.println("Reversed number: " + reversed);
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    // Method to reverse a given integer number
    public static int reverseNumber(int num) {
        int reversed = 0;

        // Loop until all digits of the number are processed
        while (num != 0) {
            // Extract the last digit of the number
            int digit = num % 10;

            // Add the digit to the reversed number after shifting previous digits to the left
            reversed = reversed * 10 + digit;

            // Remove the last digit from the original number
            num /= 10;
        }

        // Return the reversed number
        return reversed;
    }
}
