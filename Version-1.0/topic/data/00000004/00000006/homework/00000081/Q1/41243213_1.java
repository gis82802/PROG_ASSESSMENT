public class JavaHwork1 {
    public static void main(String[] args) {
        for (int i = 10000; i < 100000; i += 10000) {
            double out = 0.0;  // Reset out for each iteration of i
            for (int j = 0; j < i; j++) {
                out += (j % 2 == 0 ? 1 : -1) / (2.0 * j + 1);
            }
            out *= 4;  // Multiply by 4 to get the estimate of π
            System.out.println("Estimated value of pi with " + i + " terms: " + out);
        }
    }
}
