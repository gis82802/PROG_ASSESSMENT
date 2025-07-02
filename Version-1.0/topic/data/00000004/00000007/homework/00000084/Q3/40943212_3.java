/*
	filename:Java_1018_03
	function:�}�C�Ƨ�
	author:���ʫ� 40943212
	datetime:2024/10/18
	version:1.0
*/

import java.util.Arrays;
import java.util.Scanner;

public class Java_1018_03 {
    public static void main(String[] args) {
        // �إ�Scanner�����Ū����J
        Scanner scanner = new Scanner(System.in);

        // �ШϥΪ̿�J�}�C������
        System.out.print("�п�J�}�C������: ");
        int length = scanner.nextInt();

        // �إߤ@�ӫ��w���ת��}�C
        int[] array = new int[length];

        // ���ϥΪ̿�J�}�C���C�Ӥ���
        System.out.println("�п�J�}�C������:");
        for (int i = 0; i < length; i++) {
            System.out.print("�� " + (i + 1) + " �Ӥ���: ");
            array[i] = scanner.nextInt();
        }

        // �L�X��l�}�C
        System.out.println("��l�}�C: ");
        printArray(array);

        // �H�᭱�������̤j�ȴ�����e����
        int[] maxArray = replaceWithMax(array);

        // �L�X�H�᭱���̤j�Ȩ��N�᪺�}�C
        System.out.println("�H�᭱���̤j�Ȩ��N�᪺�}�C: ");
        printArray(maxArray);

        // �H�᭱�������̤p�ȴ�����e����
        int[] minArray = replaceWithMin(array);

        // �L�X�H�᭱���̤p�Ȩ��N�᪺�}�C
        System.out.println("�H�᭱���̤p�Ȩ��N�᪺�}�C: ");
        printArray(minArray);

        // ����Scanner����
        scanner.close();
    }

    // �N�}�C�����������᭱���̤j��
    public static int[] replaceWithMax(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        // �̫�@�Ӥ����]�� -1
        result[length - 1] = -1;

        // �q�˼ƲĤG�Ӥ����}�l����
        int max = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            result[i] = max;
            if (array[i] > max) {
                max = array[i];
            }
        }

        return result;
    }

    // �N�}�C�����������᭱���̤p��
    public static int[] replaceWithMin(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        // �̫�@�Ӥ����]�� -1
        result[length - 1] = -1;

        // �q�˼ƲĤG�Ӥ����}�l����
        int min = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            result[i] = min;
            if (array[i] < min) {
                min = array[i];
            }
        }

        return result;
    }

    // ��X�}�C
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
