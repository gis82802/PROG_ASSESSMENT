//1011上課練習_1
public class a1011_1
{
	public static double Pi(int i) {
        double num = 0.0;
        for (int k = 0; k < i; k++) {
            num += Math.pow(-1, k) / (2 * k + 1);
        }
        return 4 * num;
    }

    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i += 10000) {
            double piValue = Pi(i);
            System.out.printf("i=%d,pi=%.10f%n", i, piValue);
        }

        double targetPi = 3.14159;
        int mI = 10000;
        int step = 1000;
        while (true) {
            double piValue = Pi(mI);
            if (Math.abs(piValue - targetPi) < 0.000004699) { 
                System.out.printf("pi=3.14159, i值最小為 %d%n", mI);
                break;
            }
            mI += step;
        }
    }
}