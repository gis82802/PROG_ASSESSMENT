import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); // 上底長度
        int n = scanner.nextInt(); // 欲尋找的數字
        scanner.close();

        int i = -1, j = -1; // 儲存數字N的索引
        int currentNum = 1;
        int row = 1;

        // 尋找並印出矩陣
        while (true) {
            int rowLength = a + (row - 1);
            for (int col = 1; col <= rowLength; col++) {
                // 檢查是否找到目標數字
                if (currentNum == n) {
                    i = row;
                    j = col;
                }
                System.out.print(currentNum + " ");
                currentNum++;
            }
            System.out.println();
            
            // 如果已超過目標數字N，則可以停止
            if (currentNum > n && i != -1 && j != -1) {
                break;
            }
            row++;
        }

        // 印出結果
        if (i != -1 && j != -1) {
            System.out.println("數字 " + n + " 位於 (" + i + ", " + j + ")");
        } else {
            System.out.println("在當前梯形矩陣範圍內找不到數字 " + n);
        }
    }
}