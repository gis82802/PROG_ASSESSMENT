import java.util.Arrays;
import java.util.Scanner;

public class LineNumber {
    public LineNumber() {  // Constructor name should match the class name
        Scanner scanner = new Scanner(System.in);

        System.out.print("array length: ");
        int length = scanner.nextInt();
        
        int[] score = new int[length];

        for(int i = 0; i < length; i++) {
            int j = i + 1;
            System.out.print("array #" + j + ": ");
            score[i] = scanner.nextInt();  // Use 'i' as the index for the array
        }

        System.out.println("Array values:");
        for (int value : score) {
            System.out.print(value + " ");
        }
	System.out.println("");

	Arrays.sort(score);
	System.out.println("Sorted Array values:");
        for (int value : score) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        new LineNumber();  // Create an instance of the class to execute the constructor
	
    }
}
