import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入下三角形的高度 (n): ");
        int n = scanner.nextInt();
        //System.out.print("請輸入要尋找的數字 (num): ");
        int num = scanner.nextInt();
        scanner.close();

        int[][] triangle = new int[n][];
        int currentNumber = 1;
        int targetRow = -1, targetCol = -1;
        boolean found = false;

        // 建立並填入陣列，同時尋找目標數字
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = currentNumber;
                
                if (currentNumber == num) {
                    targetRow = i + 1;
                    targetCol = j + 1;
                    found = true;
                }
                
                System.out.print(triangle[i][j] + " ");
                currentNumber++;
            }
            System.out.println();
        }

        // 檢查目標數字是否超出範圍
        int maxNumber = n * (n + 1) / 2;
        if (num > maxNumber || num < 1) {
            System.out.println("數字 " + num + " 超出陣列範圍。");
        } else if (found) {
            System.out.println("數字 " + num + " 位於第 " + targetRow + " 列第 " + targetCol + " 行。");
        } else {
            // 理論上不會執行到這裡，因為邏輯中包含了尋找
            System.out.println("未找到數字 " + num + "。");
        }
    }
}