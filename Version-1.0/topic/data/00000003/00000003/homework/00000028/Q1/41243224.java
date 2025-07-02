import java.util.Scanner;

public class hw5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 輸入第一個矩陣的維度
        System.out.print("輸入第一個矩陣的行數: ");
        int rowsA = scanner.nextInt();
        System.out.print("輸入第一個矩陣的列數: ");
        int colsA = scanner.nextInt();
        
        // 初始化第一個矩陣
        int[][] A = new int[rowsA][colsA];
        System.out.println("輸入第一個矩陣的元素: ");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        
        // 輸入第二個矩陣的維度
        System.out.print("輸入第二個矩陣的行數: ");
        int rowsB = scanner.nextInt();
        System.out.print("輸入第二個矩陣的列數: ");
        int colsB = scanner.nextInt();
        
        // 初始化第二個矩陣
        int[][] B = new int[rowsB][colsB];
        System.out.println("輸入第二個矩陣的元素: ");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = scanner.nextInt();
            }
        }
        // 計算矩陣乘積
        int[][] result = multiplyMatrices(A, B);
        if(colsA == rowsB)
        {   
            // 顯示結果矩陣
            System.out.println("結果矩陣: ");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int rowsB = B.length;
        
        //判斷矩陣相乘是否合理
        if(colsA != rowsB)
        {
            System.out.print("null");
            return null;
        }else{
            // 初始化結果矩陣
            int[][] result = new int[rowsA][colsB];
            
            // 矩陣相乘
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < colsA; k++) {
                        result[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return result;
        }
    }
}
