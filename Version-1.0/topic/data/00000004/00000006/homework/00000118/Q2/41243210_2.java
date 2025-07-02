public class Twob {
    public static void main(String[] args) {
        int count = 0;  

        for (int num = 1; num < 100000; num++) {
            if (isWellOrdered(num)) {
                count++; 
            }
        }
        System.out.printf("小於 100000 的 well-ordered numbers 總共有 %d 個。\n", count);
    }
    private static boolean isWellOrdered(int number) {
        int[] digits = new int[10];
        int index = 0;

        while (number > 0) {
            digits[index++] = number % 10; 
            number /= 10;
        }
        for (int i = 0; i < index - 1; i++) {
            if (digits[i] <= digits[i + 1]) { 
                return false;
            }
        }
        return true;
    }
}
