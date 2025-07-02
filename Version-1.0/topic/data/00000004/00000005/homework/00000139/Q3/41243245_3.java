import java.util.Scanner;

public class CompareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("3 numbers:");

        // Input three numbers
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        // Use Math.max and Math.min to find the maximum and minimum numbers
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;
        
        // Output results
        System.out.println("max: " + max);
        System.out.println("mid: " + mid);
        System.out.println("min: " + min);
    }
}
