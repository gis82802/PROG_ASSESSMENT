/*
	filename:Java_1004_03
	function:�T���B��l
	author:���ʫ� 40943212
	datetime:2024/10/04
	version:1.0
*/

import java.util.Scanner;

public class Java_1004_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��J�T�ӼƦr
        System.out.println("�п�J�T�ӼƦr:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();

        // �ϥΤT���B��l��X�̤j��
        double max = (num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);

        // �ϥΤT���B��l��X�̤p��
        double min = (num1 < num2) ? ((num1 < num3) ? num1 : num3) : ((num2 < num3) ? num2 : num3);

        // ��X�ѤU��������
        double mid = (num1 != max && num1 != min) ? num1 :
                     (num2 != max && num2 != min) ? num2 : num3;

        // ��X���G
        System.out.println("�q�p��j�ƧǪ����G��:");
        System.out.println(min + " < " + mid + " < " + max);

        scanner.close();
    }
}
