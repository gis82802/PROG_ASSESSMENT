import java.util.Scanner;

public class hw5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter the tolerance (e.g., 0.00001 for 5 decimal places): ");
        double tolerance = scanner.nextDouble(); 
        double i = 1;
        double k = 0;
        double m = 0;
        double pu = 1;
        int iterations = 0; // 計算迭代次數
        
        do {
            k += (1.0 / ((2 * i) - 1)) * pu;
            pu *= (-1);
            i++;
            m = 4 * k;
            iterations++;
        } while (Math.abs(m - 3.14159) > tolerance);
        
        System.out.println("Approximation of Pi: " + m);
        System.out.println("Number of iterations: " + iterations);
        
        scanner.close();
    }
}



