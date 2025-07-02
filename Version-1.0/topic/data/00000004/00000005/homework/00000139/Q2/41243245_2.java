import java.util.Scanner;

public class PointToLineDistanceCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the coordinates of the point
        System.out.print("Enter the x coordinate of the point (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Enter the y coordinate of the point (y0): ");
        double y0 = scanner.nextDouble();

        // Input the slope and intercept of the line
        System.out.print("Enter the slope of the line (a): ");
        double a = scanner.nextDouble();

        System.out.print("Enter the y-intercept of the line (b): ");
        double b = scanner.nextDouble();

        // Calculate the distance from the point to the line
        double distance = Math.abs(a * x0 - y0 + b) / Math.sqrt(a * a + 1);

        // Display the result
        System.out.printf("Distance from the point is: %.2f\n", distance);
    }
}
