/*
	filename:Java_1018_04
	function:�G���}�C
	author:���ʫ� 40943212
	datetime:2024/10/18
	version:1.0
*/

import java.util.Scanner;

public class Java_1018_04 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("�п�J�x�}�j�p n (n <= 4): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > 4) {
            System.out.println("�п�J 1 �� 4 ������ n �ȡC");
            return;
        }

        int[][] matrix = new int[n][n];

        System.out.println("�п�J�x�}������:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("�п�J matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("��J���x�}�O:");
        printMatrix(matrix, n);

        System.out.print("�п�J�n�������渹 (1-" + n + "): ");
        int removeRow = scanner.nextInt() - 1; // �N 1-based �ഫ�� 0-based
        System.out.print("�п�J�n�������C�� (1-" + n + "): ");
        int removeCol = scanner.nextInt() - 1; // �N 1-based �ഫ�� 0-based


        if (removeRow < 0 || removeRow >= n || removeCol < 0 || removeCol >= n) {
            System.out.println("�渹�ΦC�����b�d�򤺡C");
            return;
        }

        int[][] newMatrix = createSubMatrix(matrix, n, removeRow, removeCol);

        System.out.println("������ " + (removeRow + 1) + " ��M�� " + (removeCol + 1) + " �C�᪺�x�}�O:");
        printMatrix(newMatrix, n - 1);

        int determinant = calculateDeterminant(newMatrix, n - 1);
        System.out.println("�s�x�}����C���O: " + determinant);

        scanner.close();
    }

    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // �Ыؤl�x�}�A�h���� removeRow ��M removeCol �C
    public static int[][] createSubMatrix(int[][] matrix, int size, int removeRow, int removeCol) {
        int[][] subMatrix = new int[size - 1][size - 1];
        int subRow = 0, subCol = 0;

        for (int i = 0; i < size; i++) {
            if (i == removeRow) continue; // ���L��������
            subCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == removeCol) continue; // ���L�������C
                subMatrix[subRow][subCol] = matrix[i][j];
                subCol++;
            }
            subRow++;
        }

        return subMatrix;
    }

    // �p��x�}����C�� (���j)
    public static int calculateDeterminant(int[][] matrix, int size) {
        if (size == 1) {
            return matrix[0][0];
        }

        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int col = 0; col < size; col++) {
            // �Ыؤl�x�}
            int[][] subMatrix = createSubMatrix(matrix, size, 0, col);
            // �p���C�� (���j)
            determinant += Math.pow(-1, col) * matrix[0][col] * calculateDeterminant(subMatrix, size - 1);
        }

        return determinant;
    }
}

