public class test {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // 印出乘法結果
                System.out.print(i * j);

                // 如果不是該行的最後一個數字，則印出空格
                if (j < 9) {
                    System.out.print(" ");
                }
            }
            // 每一列結束後換行
            System.out.println();
        }
    }
}