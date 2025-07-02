import java.util.Scanner;

public class hw1 {

    // a. MatMultiply �禡�A�Ω�x�}�ۭ�
    public static double[][] MatMultiply(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            return null; // �x�}�j�p���ŦX�A�L�k�ۭ�
        }

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    // b. invMatrix �禡�A�Ω�p�� 2x2 ��}���ϯx�}
    public static double[][] invMatrix(double[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null; // �D 2x2 ��}�A�L�k�p��ϯx�}
        }

        double det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        if (det == 0) {
            return null; // �x�}���i�f
        }

        double invDet = 1.0 / det;

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] * invDet;
        inverse[0][1] = -matrix[0][1] * invDet;
        inverse[1][0] = -matrix[1][0] * invDet;
        inverse[1][1] = matrix[0][0] * invDet;

        return inverse;
    }

    // ���L�x�}����k
    public static void printMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("�x�}�L�k�p��C");
            return;
        }
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%10.4f ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // �ϥΪ̿�J 2x2 ��}
        System.out.println("�п�J 2x2 �x�}:");
        double[][] matrix = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // ��X�ϥΪ̿�J���x�}
        System.out.println("�A��J���x�}�O:");
        printMatrix(matrix);

        // �p��ϯx�}
        double[][] inverseMatrix = invMatrix(matrix);
        System.out.println("�ϯx�}:");
        printMatrix(inverseMatrix);

        // ���Ҥϯx�}�G��x�} * �ϯx�} �O�_������x�}
        if (inverseMatrix != null) {
            double[][] identityMatrix = MatMultiply(matrix, inverseMatrix);
            System.out.println("��x�} * �ϯx�}�����G:");
            printMatrix(identityMatrix);
        }

        scanner.close();
    }
}
