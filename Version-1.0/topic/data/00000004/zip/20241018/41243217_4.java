import java.util.Scanner;

public class hw4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ū���x�}���j�p
        System.out.print("�п�J�x�}�j�p n (n <= 4): ");
        int n = scanner.nextInt();

        // �T�{ n ���W�L 4
        if (n > 4 || n < 1) {
            System.out.println("n �����b 1 �� 4 ����");
            return;
        }

        // Ū�� n x n �x�}
        int[][] matrix = new int[n][n];
        System.out.println("�п�J�x�}������:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // ��ܿ�J���x�}
        System.out.println("��J���x�}�O:");
        printMatrix(matrix);

        // Ū�����h�����C�M��
        System.out.print("�п�J�n�h�����C (i): ");
        int row = scanner.nextInt() - 1;
        System.out.print("�п�J�n�h������ (j): ");
        int col = scanner.nextInt() - 1;

        // �ˬd��J�O�_����
        if (row < 0 || row >= n || col < 0 || col >= n) {
            System.out.println("�C�Φ檺�Ȥ��X�k");
            return;
        }

        // �إߥh�� i �C�M j ��᪺�s�x�}
        int[][] newMatrix = createSubMatrix(matrix, row, col);

        // ��ܷs�x�}
        System.out.println("�h���� " + (row + 1) + " �C�M�� " + (col + 1) + " ��᪺�s�x�}�O:");
        printMatrix(newMatrix);

        // �p���C��
        int determinant = calculateDeterminant(newMatrix);
        System.out.println("�s�x�}����C���O: " + determinant);
    }

    // �C�L�x�}
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    // �Ыإh�����w�C�M��᪺�s�x�}
    public static int[][] createSubMatrix(int[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length - 1;
        int[][] subMatrix = new int[n][n];
        int r = 0, c;

        for (int i = 0; i < matrix.length; i++) {
            if (i == rowToRemove) continue;
            c = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (j == colToRemove) continue;
                subMatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }

        return subMatrix;
    }

    // �p���C��
    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            // 2x2 �x�}����C���p��
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else if (n == 3) {
            // 3x3 �x�}����C���p��
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                 - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                 + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }
        return 0; // ���d�ҥu�䴩 1x1, 2x2 �M 3x3 ����C���p��
    }
}
