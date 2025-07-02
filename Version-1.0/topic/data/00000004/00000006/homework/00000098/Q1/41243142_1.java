// File name: app5_1
// Author: 41243142
// Function: 
// Date: 24/10/11

public class app5_1 {
    public static void main(String[] args) {
        int a = 10000;
        for (int i = 1; i <= 10; i++) {
            cPi(a);
            a += 10000;  
        }
        MPi(3.14159);
    }

    public static void cPi(int iterations) {
        double pi = 0.0;
        for (int i = 0; i < iterations; i++) {
            pi += Math.pow(-1, i) / (2 * i + 1);
        }
        pi *= 4;
        System.out.printf("當 i = %d 時，π 約等於 %.6f\n", iterations, pi);
    }

    public static void MPi(double targetPi) {
        double pi = 0.0;
        int i = 0;
        while (Math.abs(pi * 4 - targetPi) > 0.000001) {
            pi += Math.pow(-1, i) / (2 * i + 1);
            i++;
        }
        System.out.printf("當 i = %d 時，π 約等於 %.6f，已接近目標π = %.6f\n", i, pi * 4, targetPi);
    }
}