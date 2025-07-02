import java.util.Scanner;

public class ch7_1_1 {

    // 矩陣乘法函數
    public static double[][] MatMultiply(double[][] mat1, double[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;

        // 檢查兩矩陣是否可進行乘法運算
        if (cols1 != rows2) {
            return null; // 若無法乘，返回null
        }

        // 創建結果矩陣
        double[][] result = new double[rows1][cols2];

        // 執行矩陣乘法
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入第一個矩陣
        System.out.println("請輸入第一個矩陣的行數與列數：");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        double[][] mat1 = new double[rows1][cols1];

        System.out.println("請輸入第一個矩陣的元素：");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                mat1[i][j] = scanner.nextDouble();
            }
        }

        // 輸入第二個矩陣
        System.out.println("請輸入第二個矩陣的行數與列數：");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();
        double[][] mat2 = new double[rows2][cols2];

        System.out.println("請輸入第二個矩陣的元素：");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                mat2[i][j] = scanner.nextDouble();
            }
        }

        // 執行矩陣乘法
        double[][] product = MatMultiply(mat1, mat2);

        // 輸出結果
        if (product != null) {
            System.out.println("矩陣乘法結果:");
            for (int i = 0; i < product.length; i++) {
                for (int j = 0; j < product[0].length; j++) {
                    System.out.printf("%.2f ", product[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("這兩個矩陣無法相乘");
        }

        scanner.close();
    }
}
