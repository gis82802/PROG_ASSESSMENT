public class java5_5_1 {
    public static void main(String[] args) {
        double pi = 0.0;
        int i = 1;
        int j = 1;

        while (Math.abs(pi * 4 - 3.14159) > 0.00001) {
            if (i % 2 == 1) {
                pi += 1.0 / (2 * i - 1);
            } else {
                pi -= 1.0 / (2 * i - 1);
            }
            i++;
        }
        pi *= 4;
        System.out.printf(" π = 3.14159, 計算結果 i = %d, 計算出的 π = %.10f%n", i, pi);
    }
}
