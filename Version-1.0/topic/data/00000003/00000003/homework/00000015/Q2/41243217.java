import java.util.Scanner;

public class hw2 {

    // MatMultiply �禡�A�Ω�x�}�ۭ�
    public static double[][] MatMultiply(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;        // matrix1 �����
        int cols1 = matrix1[0].length;     // matrix1 ���C��
        int rows2 = matrix2.length;        // matrix2 �����
        int cols2 = matrix2[0].length;     // matrix2 ���C��

        // �p�G matrix1 ���C�Ƥ����� matrix2 ����ơA�h�L�k�i��x�}�ۭ�
        if (cols1 != rows2) {
            return null; // ��^ null�A��ܵL�k�ۭ�
        }

        // �إߤ@�ӷs���x�}�Ӧs�x���n���G
        double[][] result = new double[rows1][cols2];

        // �x�}�ۭ�����k
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result; // ��^�ۭ����G���x�}
    }

    // �Ψӥ��L�x�}����k
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

    // Ū���ϥΪ̿�J���x�}
    public static double[][] inputMatrix(Scanner scanner, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        System.out.println("�п�J�x�}������:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��J�Ĥ@�ӯx�}���j�p
        System.out.print("�п�J�Ĥ@�ӯx�}�����: ");
        int rows1 = scanner.nextInt();
        System.out.print("�п�J�Ĥ@�ӯx�}���C��: ");
        int cols1 = scanner.nextInt();

        // ��J�Ĥ@�ӯx�}
        double[][] matrix1 = inputMatrix(scanner, rows1, cols1);

        // ��J�ĤG�ӯx�}���j�p
        System.out.print("�п�J�ĤG�ӯx�}�����: ");
        int rows2 = scanner.nextInt();
        System.out.print("�п�J�ĤG�ӯx�}���C��: ");
        int cols2 = scanner.nextInt();

        // ��J�ĤG�ӯx�}
        double[][] matrix2 = inputMatrix(scanner, rows2, cols2);

        // ��X�ϥΪ̿�J���x�}
        System.out.println("�Ĥ@�ӯx�}�O:");
        printMatrix(matrix1);
        System.out.println("�ĤG�ӯx�}�O:");
        printMatrix(matrix2);

        // �x�}�ۭ�
        double[][] result = MatMultiply(matrix1, matrix2);

        // ��ܵ��G�ο��~�T��
        if (result != null) {
            System.out.println("�x�}�ۭ������G�O:");
            printMatrix(result);
        } else {
            System.out.println("���~�G�x�}���j�p���ŦX�ۭ�����C");
        }

        scanner.close();
    }
}
