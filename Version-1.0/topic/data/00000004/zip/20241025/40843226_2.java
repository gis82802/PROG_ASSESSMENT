// (b) 計算2x2矩陣的反矩陣
import java.util.Scanner;

public class MatrixInverse {
    public static double[][] invMatrix(double[][] matrix) {
       
        if (matrix == null || matrix.length != 2 || 
            matrix[0].length != 2 || matrix[1].length != 2) {
            return null;
        }
        
        // 計算行列式
        double det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        
        // 檢查行列式是否為 0
        if (det == 0) {
            return null;
        }
        
        // 計算反矩陣
        double[][] result = new double[2][2];
        result[0][0] = matrix[1][1] / det;
        result[0][1] = -matrix[0][1] / det;
        result[1][0] = -matrix[1][0] / det;
        result[1][1] = matrix[0][0] / det;
        
        return result;
    }

    // 輔助方法：輸入2x2矩陣
    private static double[][] inputMatrix(Scanner scanner) {
        double[][] matrix = new double[2][2];
        
        System.out.println("請輸入2x2矩陣的元素：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("請輸入 [%d][%d] 位置的元素: ", i+1, j+1);
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    // 輔助方法：印出矩陣
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.printf("%.4f\t", num);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // 輸入2x2矩陣
            double[][] matrix = inputMatrix(scanner);
            
            System.out.println("\n原始矩陣：");
            printMatrix(matrix);
            
            // 計算反矩陣
            double[][] inverse = invMatrix(matrix);
            
            if (inverse != null) {
                System.out.println("\n反矩陣：");
                printMatrix(inverse);
                
                // 驗證結果
                System.out.println("\n驗證結果（應該是單位矩陣）：");
                double[][] product = MatrixMultiplication.MatMultiply(matrix, inverse);
                printMatrix(product);
                
                // 檢查是否為單位矩陣
                boolean isIdentity = true;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (i == j) {
                            if (Math.abs(product[i][j] - 1.0) > 1e-10) {
                                isIdentity = false;
                            }
                        } else {
                            if (Math.abs(product[i][j]) > 1e-10) {
                                isIdentity = false;
                            }
                        }
                    }
                }
                System.out.println("\n驗證結果：" + 
                    (isIdentity ? "反矩陣計算正確！" : "驗證失敗！"));
                
            } else {
                System.out.println("\n此矩陣無法求反矩陣（行列式為0）");
            }
            
        } catch (Exception e) {
            System.out.println("錯誤：輸入無效！請輸入有效的數字。");
        } finally {
            scanner.close();
        }
    }
}