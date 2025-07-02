// file name: app6_3
// author: 41243142
// version:
// function: 
// date: 24/10/18

import java.util.Scanner;

public class app6_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("�п�J�T���ΰ��� (0 < n <= 20): ");
        int n = scanner.nextInt();
        
        if (n <= 0 || n > 20) {
            System.out.println("���ץ����b 1 �� 20 ����");
            return;
        }

        System.out.println("�U�T���ΡG");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.print("�п�J�S�w�Ʀr (num < 100000): ");
        int num = scanner.nextInt();
        
        if (num >= 100000) {
            System.out.println("�Ʀr�����p�� 100000");
            return;
        }
        int rows = (int) Math.ceil((Math.sqrt(1 + 8 * num) - 1) / 2);
        int[][] tri = new int[rows][];
        int count = 1;

        for (int i = 0; i < rows; i++) {
            tri[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                tri[i][j] = count++;
            }
        }

        int ccount = 0;  
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (tri[i][j] == num) {
                    System.out.println("�Ʀr " + num + " �X�{�b��m (" + (i + 1) + ", " + (j + 1) + ")");
                    ccount++;
                }
            }
        }

        if (ccount == 0) {
            System.out.println("�Ʀr " + num + " �b�U�T���Τ��䤣��C");
        }
    }
}
