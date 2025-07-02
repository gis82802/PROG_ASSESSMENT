/*
	filename:Java_1011_03
	function:�N��J���Ʀr����
	author:���ʫ� 40943212
	datetime:2024/10/11
	version:1.0
*/

import java.util.Scanner;

public class Java_1011_03 {
    
    // ����@�Ӿ��
    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;   // ���X�̫�@���
            reversed = reversed * 10 + digit;  // �N���X���Ʀr�[����઺�Ʀr�W
            number /= 10;   // �����w�g���X���̫�@���
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ��J�@�Ӿ��
        System.out.print("�п�J�@�Ӿ�ƨӶi�����: ");
        int inputNumber = scanner.nextInt();
        
        // �p�����ܤ���᪺���G
        int reversedNumber = reverseNumber(inputNumber);
        System.out.println("����᪺�Ʀr�O: " + reversedNumber);
        
        scanner.close();
    }
}

