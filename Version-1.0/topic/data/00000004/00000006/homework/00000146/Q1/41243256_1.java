public class owoblue_java08 {
    public static void main(String[] args) {
		System.out.println("已知ip=4(1-1/3+1/5-1/7+1/9-...-1/2i-1+i/2i+1)");
		System.out.println("則i = 10000, 20000, ..., 100000 的i值");
        for (int i = 10000; i <= 100000; i += 10000) {
            double pi = calculatePi(i);
            System.out.printf("i = %d, pi=%.5f%n", i, pi);
        }

        double targetPi = 3.14159;
        double tolerance = 0.00001;
        int i = 0;
        double pi = 0.0;

        while (Math.abs(pi - targetPi) >= tolerance) {
            i += 1000;
            pi = calculatePi(i);
        }

        System.out.printf("若要得到 pi=3.14159,最小的i值約為 %d", i, pi);
    }

    public static double calculatePi(int i) {
        double sum = 0.0;

        for (int j = 0; j <= i; j++) {
            sum += (j % 2 == 0 ? 1.0 : -1.0) / (2 * j + 1);
        }

        return 4 * sum;
    }
}
