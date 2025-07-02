public class homework3_1 {
    public static void main(String[] args) {
        double total = 0;
        int input = 0;
        double x = 0;
        double c;

        for (int d = 0; d < 10; d++) {
            input += 10000;
            for (int a = 1; a < input; a++) {
                c = 0;
                if (a % 2 == 0) {
                    c = (2 * a - 1);
                    c = 1 / c;
                    x -= c;
                } else {
                    c = (2 * a - 1);
                    c = 1 / c;
                    x += c;
                }
            }
            total = x * 4;
            System.out.println("pi = " + total);
            total = 0;
            x =0;
        }
    }
}
