/*
	filename:Java_1018_01
	function:�}�C�Ƨ�
	author:���ʫ� 40943212
	datetime:2024/10/18
	version:1.0
*/

import java.util.Arrays;
import java.util.Scanner;

public class Java_1018_01 {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("�п�J�}�C������: ");
        int length = scanner.nextInt();

        int[] array = new int[length];

        System.out.println("�п�J�}�C������:");
        for (int i = 0; i < length; i++) {
            System.out.print("�� " + (i + 1) + " �Ӥ���: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("�Ƨǫe���}�C: " + Arrays.toString(array));

        // �ϥ�Arrays.sort�i��Ƨ�
        Arrays.sort(array);

        System.out.println("�Ƨǫ᪺�}�C: " + Arrays.toString(array));

        scanner.close();
    }
}



