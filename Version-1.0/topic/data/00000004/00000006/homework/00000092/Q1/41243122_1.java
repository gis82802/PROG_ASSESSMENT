public class Pi {
    public static void main(String[] args) {
        for (int k = 10000; k <= 100000; k += 10000) {
            double p = 0;
            for (double i = 1; i <= k; i++) {
                p += Math.pow(-1, i - 1) / (2 * i - 1);
            }
            System.out.printf("i=%d的時候, pi=%.15f\n", k, p * 4);
        }
        double pi = 0;
        int r = 0;
        for (double g = 1; Math.abs(pi * 4 - 3.14159) > 0.00001; g++) {
            pi += Math.pow(-1, g - 1) / (2 * g - 1);
            r++;
        }
        System.out.println("最靠近3.14159的數: " + r);
    }
}
