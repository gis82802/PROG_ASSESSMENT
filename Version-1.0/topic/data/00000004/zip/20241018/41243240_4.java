/*
filename:hw4
function:輸入陣列大小，刪除行與列，計算該陣列的行列式值
author:傅學呈
data:2024/10/18
version:11.0.12
*/
import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 讓使用者輸入矩陣大小
        System.out.println("請輸入矩陣的大小(n不超過4)：");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        // 讓使用者輸入矩陣內容
        System.out.println("請輸入矩陣元素(依次填入每一行的數值)：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

	// 印出原始陣列內容
	System.out.println("原陣列內容：");
	for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");            
	    }
	    System.out.println("");
        }
        // 讓使用者輸入要刪除的行和列
        System.out.println("請輸入要刪除的行數(從0開始)：");
        int rowDel = scanner.nextInt();
        System.out.println("請輸入要刪除的列數(從0開始)：");
        int colDel = scanner.nextInt();
        
        // 生成刪除指定行和列後的新矩陣
        int[][] subMatrix = new int[n-1][n-1];
        for (int i = 0, subI = 0; i < n; i++) {
            if (i == rowDel) continue; // 跳過要刪除的行
            for (int j = 0, subJ = 0; j < n; j++) {
                if (j == colDel) continue; // 跳過要刪除的列
                subMatrix[subI][subJ] = matrix[i][j];
                subJ++; //新矩陣的列索引
            }
            subI++; //新矩陣的行索引
        }
        //輸出刪除後的陣列內容
	System.out.println("刪除第"+rowDel+"行第"+colDel+"列的陣列內容：");
	for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                System.out.print(subMatrix[i][j]+" ");            
	    }
	    System.out.println("");
        }
        // 計算並輸出新矩陣的行列式結果
        int ans = calculate(subMatrix, n-1);
        System.out.println("刪除行與列後的矩陣行列式為：" + ans);
    }

    // 計算n x n矩陣的行列式
    public static int calculate(int[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[][] subMatrix = new int[n-1][n-1];
            for (int j = 1; j < n; j++) {
                for (int k = 0, subK = 0; k < n; k++) {
                    if (k == i) continue;
                    subMatrix[j-1][subK] = matrix[j][k];
                    subK++;
                }
            }
            ans += Math.pow(-1, i) * matrix[0][i] * calculate(subMatrix, n-1);
        }
        return ans;
    }
}
