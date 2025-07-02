import java.util.Scanner;

public class TrianglesWithStarsAndNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ���o�T���ΰ���
        System.out.print("�п�J�T���Ϊ����� (1-20): ");
        int n = scanner.nextInt();

        // �ˬd���׬O�_�b�d��
        if (n < 1 || n > 20) {
            System.out.println("���ץ����b 1 �� 20 �����I");
            return;
        }

        // Part (a): �إߨ���ܤW�T����
        System.out.println("�W�T���� (�ϥ�*���)�G");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");  // �ϥ�*�Ÿ�
            }
            System.out.println(); // ����
        }

        // Part (b): �إߨ���ܤU�T����
        System.out.println("�U�T���� (�ϥ�*���)�G");
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");  // �ϥ�*�Ÿ�
            }
            System.out.println(); // ����
        }

        // Part (c): ��R�U�T���ίx�}�ìd��S�w�Ʀr
        System.out.print("�п�J�@�Ӥp��100000���Ʀr: ");
        int num = scanner.nextInt();

        // �̤j�ؤo�H�T�O�Ʀr�b�d��
        int maxSize = 447; // 447*(448)/2 = 100056, �̤j���T����
        int[][] triangleNumbers = new int[maxSize][];

        // ��R�U�T���ίx�}
        int count = 1; // �Ω��R�Ʀr
        for (int i = 0; i < maxSize; i++) {
            triangleNumbers[i] = new int[i + 1]; // �C�檺�C��
            for (int j = 0; j <= i; j++) {
                triangleNumbers[i][j] = count; // ��J���ǼƦr
                count++;
            }
        }

        // �d����w�Ʀr����m
        boolean found = false;
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j <= i; j++) {
                if (triangleNumbers[i][j] == num) {
                    System.out.println("�Ʀr " + num + " �X�{�b�� " + (i + 1) + " �C " + (j + 1));
                    found = true;
                    break; // ���ᰱ��d��
                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("�Ʀr " + num + " ���b�U�T���Τ��C");
        }

        scanner.close();
    }
}
