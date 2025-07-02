public class hw5 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 10000; i++) {
            if (isWellOrdered(i)) {
                count++;
            }
        }
        System.out.println("1 �� 10000 ���� Well-Ordered Number �ƶq��: " + count);
    }

    public static boolean isWellOrdered(int number) {
        int prevDigit = 10;
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit >= prevDigit) {
                return false;
            }
            prevDigit = currentDigit;
            number /= 10;
        }
        return true;
    }
}
