/*
	filename:Java_0927_01
	function:����I�D��{���B�Z���B�V�q
	author:���ʫ� 40943212
	datetime:2024/10/04
	version:1.0
*/

import java.util.Scanner;

public class Java_1004_01 {

    // ��J����I���y��
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("��J�Ĥ@���I�� x �M y:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("��J�ĤG���I�� x �M y:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        //�p��q�L����I�����u��{��
        calculateLineEquation(x1, y1, x2, y2);

        //�p��Z��
        double euclideanDist = euclideanDistance(x1, y1, x2, y2);
        double manhattanDist = manhattanDistance(x1, y1, x2, y2);
        double minkowskiDist = minkowskiDistance(x1, y1, x2, y2, 3);

        System.out.printf("�ڦ��Z��: %.2f%n", euclideanDist);
        System.out.printf("�ҫ��y�Z��: %.2f%n", manhattanDist);
        System.out.printf("Minkowski�Z�� (p=3): %.2f%n", minkowskiDist);

        //�p���ӦV�q����������
        double angle = calculateAngleBetweenVectors(x1, y1, x2, y2);
        System.out.printf("�V�q���������� (�H�׼ƪ��): %.2f ��%n", Math.toDegrees(angle));

        scanner.close();
    }

    //�p��q�L����I�����u��{��
    public static void calculateLineEquation(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            System.out.println("�o�O�@�������u�A��{���� x = " + x1);
        } else {
            double slope = (y2 - y1) / (x2 - x1);
            double intercept = y1 - slope * x1;
            System.out.println("���u��{����: y = " + slope + "x + " + intercept);
        }
    }

    //�p��ڦ��Z��
    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    //�p��ҫ��y�Z��
    public static double manhattanDistance(double x1, double y1, double x2, double y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    //�p�� Minkowski �Z��
    public static double minkowskiDistance(double x1, double y1, double x2, double y2, int p) {
        return Math.pow(Math.pow(Math.abs(x2 - x1), p) + Math.pow(Math.abs(y2 - y1), p), 1.0 / p);
    }

    //�p���ӦV�q������
    public static double calculateAngleBetweenVectors(double x1, double y1, double x2, double y2) {
        double dotProduct = x1 * x2 + y1 * y2;
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1);
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2);

        return Math.acos(dotProduct / (magnitudeA * magnitudeB));
    }
}

