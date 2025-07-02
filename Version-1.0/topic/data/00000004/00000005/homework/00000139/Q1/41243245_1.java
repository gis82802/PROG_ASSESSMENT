import java.util.Scanner;

public class LineEquationCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the coordinates of two points and the Minkowski distance calculation method
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        System.out.print("Enter Minkowski p (default 2 for Euclidean): ");
        double p = scanner.nextDouble();

        // Calculate results
        calculateResults(x1, y1, x2, y2, p);
    }

    // Calculate linear equation and distances
    private static void calculateResults(double x1, double y1, double x2, double y2, double p) {
        // Check if the line is vertical
        if (x1 == x2) {
            System.out.println("Equation: x = " + x1);
        } else {
            // Calculate slope m and intercept b
            double m = (y2 - y1) / (x1 - x2);
            double b = y1 - m * x1;

            // Output linear equation
            System.out.printf("Equation: y = %.2fx + %.2f%n", m, b);
        }

        // Calculate Euclidean distance
        double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Calculate Manhattan distance
        double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);

        // Calculate Minkowski distance
        double minkowskiDistance = Math.pow(Math.pow(Math.abs(x2 - x1), p) + Math.pow(Math.abs(y2 - y1), p), 1 / p);

        // Display results
        System.out.printf("Euclidean Distance: %.2f%n", euclideanDistance);
        System.out.printf("Manhattan Distance: %.2f%n", manhattanDistance);
        System.out.printf("Minkowski Distance: %.2f (p=%.1f)%n", minkowskiDistance, p);
    }
}
