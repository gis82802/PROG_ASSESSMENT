import java.util.Arrays;
import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ���ܨϥΪ̿�J�}�C���j�p
        System.out.print("�п�J�}�C���j�p: ");
        int size = scanner.nextInt();

        // �إ߰}�C
        int[] arr = new int[size];

        // ���ܨϥΪ̿�J�}�C������
        System.out.println("�п�J�}�C�������G");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // ��X�Ƨǫe���}�C
        System.out.println("�Ƨǫe: " + Arrays.toString(arr));

        // ��}�C�i��Ƨ�
        Arrays.sort(arr);

        // ��X�Ƨǫ᪺�}�C
        System.out.println("�Ƨǫ�: " + Arrays.toString(arr));
        
        scanner.close();
    }
}
