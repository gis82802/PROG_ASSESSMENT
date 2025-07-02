public class java5_5_3 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (isWellOrdered(i)) {
                count++;
            }
        }
        System.out.println("Number of well-ordered numbers less than 10000: " + count);
    }

    // 判斷一個數字是否是well-ordered number
    public static boolean isWellOrdered(int number) {
        int previousDigit = 10; // 比最大的單位數 9 還要大
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit >= previousDigit) {
                return false;
            }
            previousDigit = currentDigit;
            number /= 10;
        }
        return true;
    }
}
