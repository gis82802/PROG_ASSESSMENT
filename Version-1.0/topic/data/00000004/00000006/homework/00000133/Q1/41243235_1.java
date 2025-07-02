public class hw {
    public static void main(String[] args) {
        // Define the list of terms to compute
        int[] termsList = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};

        // Loop through the terms and calculate the approximate value of pi
        for (int terms : termsList) {
            double pi = approximatePi(terms);
            System.out.printf("For i = %d, pi ≈ %.10f%n", terms, pi);
        }
    }

    // Method to approximate the value of pi using the given series
    public static double approximatePi(int terms) {
        double piApprox = 0.0;

        // Calculate the sum using the given series
        for (int i = 0; i < terms; i++) {
            // Alternating series: add when i is even, subtract when i is odd
            piApprox += Math.pow(-1, i) / (2 * i + 1);
        }

        // Multiply the result by 4 to get pi
        return 4 * piApprox;
    }
}

