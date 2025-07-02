/*
	filename:Java_1011_01
	function:pi�ȭp��
	author:���ʫ� 40943212
	datetime:2024/10/11
	version:1.0
*/

public class Java_1011_01 {
    // �p�⤽����pi��
    public static double calculatePi(int terms) {
        double pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            // �����p��
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        return 4 * pi;
    }

    public static void main(String[] args) {
        // (a) �p�� i �� pi ��
        int[] termValues = {10000, 20000, 50000, 100000}; 
        System.out.println("�p�� i = 10000, 20000, 50000, 100000 �ɪ� pi ��:");
        for (int terms : termValues) {
            double pi = calculatePi(terms);
            System.out.printf("i = %d �ɡA�k ? %.10f%n", terms, pi);
        }

        // (b) ���� pi ���� 3.14159 ���̤p i
        double targetPi = 3.14159;
        int minI = 0;
        for (int i = 1; ; i++) {
            double pi = calculatePi(i);
            if (Math.abs(pi - targetPi) < 0.00001) { // �]�w�~�t
                minI = i;
                System.out.printf("�̤p�� i �ȡA�ϱo pi ? %.5f �O: %d%n", targetPi, minI);
                break;
            }
        }
    }
}


