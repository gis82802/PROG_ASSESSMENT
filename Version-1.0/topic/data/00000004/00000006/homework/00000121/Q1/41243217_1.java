public class hw2 {
    public static void main(String[] args) {
        int[] terms = {10000, 20000, 50000, 100000};  // ���P�� i ��
        for (int i : terms) {
            System.out.println("�� i = " + i + " �ɡA�k �������: " + calculatePi(i));
        }
    }

    public static double calculatePi(int terms) {
        double pi = 0.0;
        for (int i = 0; i < terms; i++) {
            // �ϥΤ��� �k = 4 * (1 - 1/3 + 1/5 - 1/7 + ... )
            pi += Math.pow(-1, i) / (2.0 * i + 1.0);
        }
        return 4 * pi;  // �̫᭼�H4
    }
}
