import java.util.Scanner;
import Jama.Matrix;

public class Test4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //========= 輸入矩陣
        System.out.printf("請輸入正矩陣的邊長 n: ");
        int n = s.nextInt();
        System.out.printf("請輸入矩陣各項的值: ");
        
        double[][] arr1 = new double[n][n];  // 宣告邊長為 n 的二維陣列存放矩陣值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[i][j] = s.nextDouble();
            }
        }
        
        //========= 轉換陣列和列出矩陣
        Matrix M1 = new Matrix(arr1);  // 將二維陣列轉換為 Jama 的矩陣型態
        M1.print(3, 2);  // Jama 的矩陣輸出方式，其中 3 為輸出寬度，2 為小數點後位數

        //========= 輸入刪除的列與行
        System.out.printf("請輸入要刪除的列與行: ");
        int RTR = s.nextInt();
        if (RTR > n) {
            System.out.printf("輸入值錯誤，請重新輸入: ");
            RTR = s.nextInt();
        }
        
        int CTR = s.nextInt();
        if (CTR > n) {
            System.out.printf("輸入值錯誤，請重新輸入: ");
            CTR = s.nextInt();
        }
        
        RTR--; // 因為陣列位置從 0 開始，所以要 -1
        CTR--; // 同上
        
        //========= 處理刪除工作
        double[][] arr2 = new double[n - 1][n - 1];  // 宣告少一列及一行的新陣列
        
        int r = 0;  // arr2 陣列的列與行變數
        for (int i = 0; i < n; i++) {
            int c = 0;
            if (i == RTR) continue;  // 遇到要刪除的列就跳過
            for (int j = 0; j < n; j++) {
                if (j == CTR) continue;  // 遇到要刪除的行就跳過
                arr2[r][c] = arr1[i][j];
                c++;
            }
            r++;
        }
        
        //========= 輸出結果
        Matrix M2 = new Matrix(arr2);  // 將新陣列也轉換為 Jama 的矩陣型態
        M2.print(3, 2);  // 輸出新矩陣
        
        double det = M2.det();  // 計算行列式值
        System.out.printf("行列式值為: %.3f", det);
        
        s.close();
    }
}