public class hw2 {
    public static void main(String[] args) {
        int[] terms = {10000, 20000, 50000, 100000};  // 不同的 i 值
        for (int i : terms) {
            System.out.println("當 i = " + i + " 時，π 的近似值: " + calculatePi(i));
        }
    }

    public static double calculatePi(int terms) {
        double pi = 0.0;
        for (int i = 0; i < terms; i++) {
            // 使用公式 π = 4 * (1 - 1/3 + 1/5 - 1/7 + ... )
            pi += Math.pow(-1, i) / (2.0 * i + 1.0);
        }
        return 4 * pi;  // 最後乘以4
    }
}
