public class Pi {

    public static void main(String[] args) {
        // (a) 計算當 i = 10000, 20000,..., 到 100000 時的 pi 值
        System.out.println("Part (a):");
        for (int i = 10000; i <= 100000; i += 10000) {
            double pi = calculatePi(i);
            System.out.printf("Approximation of Pi after %d terms: %.10f%n", i, pi);
        }

        // (b) 找到使得 pi 接近 3.14159 的最小項數
        System.out.println("\nPart (b):");
        double targetPi = 3.14159;
        int minTerms = findMinTermsForPi(targetPi);
        System.out.printf("Minimum terms needed to approximate Pi to %.5f: %d terms%n", targetPi, minTerms);
    }

    // 計算 pi 的近似值
    public static double calculatePi(int iterations) {
        double pi = 0.0;
        for (int i = 0; i < iterations; i++) {
            if (i % 2 == 0) {
                pi += 1.0 / (2 * i + 1);
            } else {
                pi -= 1.0 / (2 * i + 1);
            }
        }
        pi *= 4; // 最後乘以 4 得到 π 的近似值
        return pi;
    }

    // 找到使得 pi 接近目標值的最小項數
    public static int findMinTermsForPi(double targetPi) {
        double pi = 0.0;
        int terms = 0;
        while (true) {
            if (terms % 2 == 0) {
                pi += 1.0 / (2 * terms + 1);
            } else {
                pi -= 1.0 / (2 * terms + 1);
            }
            if (Math.abs(pi * 4 - targetPi) < 0.00001) {
                // 當 pi 與目標值的誤差小於 0.00001 時停止
                break;
            }
            terms++;
        }
        return terms + 1; // 返回項數
    }
}
