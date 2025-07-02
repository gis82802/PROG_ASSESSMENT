/*
	filename:Java_1004_02
	function:�p�����I�P��{�����Z��
	author:���ʫ� 40943212
	datetime:2024/10/04
	version:1.0
*/

import java.util.Scanner;

public class Java_1004_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��J�G������I
        System.out.println("�п�J�I�� x �M y �y��:");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        // ��J���u��{��
        System.out.println("�п�J���u��{�����Y�� (A, B, C)�A�ϱo Ax + By + C = 0:");
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();

        // �p���I�쪽�u���Z��
        double distance = calculateDistanceToLine(x, y, A, B, C);
        System.out.printf("�I (%.2f, %.2f) �쪽�u %.2fx + %.2fy + %.2f = 0 ���Z����: %.2f%n", x, y, A, B, C, distance);

        scanner.close();
    }

    // �p���I�쪽�u���Z��
    public static double calculateDistanceToLine(double x, double y, double A, double B, double C) {
        // �Z������
        double numerator = Math.abs(A * x + B * y + C);
        double denominator = Math.sqrt(A * A + B * B);
        return numerator / denominator;
    }
}


