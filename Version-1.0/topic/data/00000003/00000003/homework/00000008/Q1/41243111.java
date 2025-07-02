import java.util.Scanner;
import Jama.Matrix;

public class Test3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //========= 輸入矩陣
        System.out.printf("請輸入第一個矩陣的列: ");
        int r = s.nextInt();
        System.out.printf("請輸入第一個矩陣的行: ");
        int c = s.nextInt();
        System.out.printf("請輸入矩陣第一個矩陣的值: ");
        
        double[][] arr1 = new double[r][c];  // 輸入第一個矩陣
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr1[i][j] = s.nextDouble();
            }
        }
        Matrix M1 = new Matrix(arr1);
        
        System.out.printf("請輸入第二個矩陣的列: ");
        r = s.nextInt();
        System.out.printf("請輸入第二個矩陣的行: ");
        c = s.nextInt();
        System.out.printf("請輸入矩陣第二個矩陣的值: ");
        
        double[][] arr2 = new double[r][c];  // 輸入第二個矩陣
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr2[i][j] = s.nextDouble();
            }
        }
        Matrix M2 = new Matrix(arr2);

        //========= 處理輸出
        M1.print(4, 1);
        System.out.printf("     乘上\n");
        M2.print(4, 1);
        System.out.printf("     等於\n");
        
        Matrix temp = MatMultiply(M1,M2);
        if(temp != null) {
            temp.print(4, 1);
        } else {
            System.out.printf("        無法相乘\n");
        }
        
        System.out.printf("第一個矩陣的反矩陣為\n");
        temp = invMatrix(M1);
        if(temp != null) {
            temp.print(4, 1);
        } else {
            System.out.printf("無法求反矩陣\n");
        }
        
        System.out.printf("第二個矩陣的反矩陣為\n");
        temp = invMatrix(M2);
        if(temp != null) {
            temp.print(4, 1);
        } else {
            System.out.printf("無法求反矩陣\n");
        }
        
        s.close();
    }
    
    public static Matrix MatMultiply (Matrix M1,Matrix M2) {
        if(M1.getColumnDimension() == M2.getRowDimension()) {
            Matrix temp = M1.times(M2);
            return temp;
        } else {
            return null;
        }
    }
    
    public static Matrix invMatrix (Matrix M) {
        if(M.getColumnDimension() == M.getRowDimension()) {
            Matrix temp = M.inverse();
            return temp;
        } else {
            return null;
        }
    }
}