import java.util.Scanner;
import Jama.Matrix;

public class HW1025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("請輸入第一個矩陣的列：");
        int r1 = sc.nextInt();
        System.out.printf("請輸入第一個矩陣的行：");
        int c1 = sc.nextInt();
        System.out.printf("請輸入第一個矩陣的值：\n");
        double[][] arr1 = new double[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                arr1[i][j] = sc.nextDouble();
            }
        }
        Matrix m1 = new Matrix(arr1);

        System.out.printf("請輸入第二個矩陣的列：");
        int r2 = sc.nextInt();
        System.out.printf("請輸入第二個矩陣的行：");
        int c2 = sc.nextInt();
        System.out.printf("請輸入第二個矩陣的值：\n");
        double[][] arr2 = new double[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                arr2[i][j] = sc.nextDouble();
            }
        }
        Matrix m2 = new Matrix(arr2);

        // 輸出矩陣
        System.out.printf("\n第一個矩陣為：\n");
        m1.print(4, 1);
        System.out.printf("\n第二個矩陣為：\n");
        m2.print(4, 1);
        System.out.printf("\n乘上：\n");
        Matrix res = MatMul(m1, m2);
        if (res != null) {
            System.out.printf("\n等於：\n");
            res.print(4, 1);
        } else {
            System.out.printf("無法相乘\n");
        }

        System.out.printf("\n第一個矩陣的反矩陣為：\n");
        Matrix invM1 = InvMat(m1);
        if (invM1 != null) {
            invM1.print(4, 1);
        } else {
            System.out.printf("無法求反矩陣\n");
        }

        System.out.printf("\n第二個矩陣的反矩陣為：\n");
        Matrix invM2 = InvMat(m2);
        if (invM2 != null) {
            invM2.print(4, 1);
        } else {
            System.out.printf("無法求反矩陣\n");
        }

        sc.close();
    }

    public static Matrix MatMul(Matrix m1, Matrix m2) {
        if (m1.getColumnDimension() != m2.getRowDimension()) {
            return null;
        }
        return m1.times(m2);
    }

    public static Matrix InvMat(Matrix m) {
        if (m.getRowDimension() != 2 || m.getColumnDimension() != 2) {
            return null;
        }
        double determinant = m.get(0, 0) * m.get(1, 1) - m.get(0, 1) * m.get(1, 0);
        if (determinant == 0) {
            return null;
        }
        double[][] invArr = new double[2][2];
        invArr[0][0] = m.get(1, 1) / determinant;
        invArr[0][1] = -m.get(0, 1) / determinant;
        invArr[1][0] = -m.get(1, 0) / determinant;
        invArr[1][1] = m.get(0, 0) / determinant;

        return new Matrix(invArr);
    }
}
