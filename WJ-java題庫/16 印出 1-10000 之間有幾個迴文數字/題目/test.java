public class test {

    // 判斷一個數字是否為迴文
    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        int count = 0;
        int numberPerLine = 0;

        for (int i = 1; i <= 10000; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
                count++;
                numberPerLine++;
                
                // 每10個數字換行
                if (numberPerLine % 10 == 0) {
                    System.out.println();
                }
            }
        }
        
        // 確保最後一行換行
        if (numberPerLine % 10 != 0) {
            System.out.println();
        }

        System.out.println("總共有 " + count + " 個迴文數字");
    }
}