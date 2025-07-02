public class Main {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            System.out.println( "i = " + i*10000 +" π = "+ Pi(i*10000));
        }

        int Minimum  = 1;
        double pi = 0.0;
        while (Math.abs(4 * pi - 3.14159) > 0.00001) {
            double term = (Minimum % 2 == 1 ? 1.0 : -1.0) / (2 * Minimum - 1);
            pi += term;
            Minimum++;
        }
        System.out.println("Minimum i for π = 3.14159 is: " + Minimum);
    }

    public static double Pi(int n) {
        double pi = 0.0;
        for (int i = 1; i <= n; i++) {
            double term = (i % 2 == 1 ? 1.0 : -1.0) / (2 * i - 1);
            pi += term;
        }
        return 4 * pi;
    }


}
