import java.util.Arrays;

public class hw2 {
    public static void main(String[] args) {
        int[] arr = {35, 8, 43, 6, 7, 1, 2};

        // �إߨ�ӵ��G�}�C�A�@�Ӧs��᭱�Ҧ��������̤j�ȡA�@�Ӧs��̤p��
        int[] maxResult = new int[arr.length];
        int[] minResult = new int[arr.length];

        // �̫�@�Ӥ����᭱�S����L�����A�]���]�� -1
        maxResult[arr.length - 1] = -1;
        minResult[arr.length - 1] = -1;

        // �q�˼ƲĤG�Ӥ����}�l�B�z�A���e�M��
        for (int i = arr.length - 2; i >= 0; i--) {
            // �p��᭱�Ҧ��������̤j�ȩM�̤p��
            maxResult[i] = Math.max(arr[i + 1], maxResult[i + 1] == -1 ? arr[i + 1] : maxResult[i + 1]);
            minResult[i] = Math.min(arr[i + 1], minResult[i + 1] == -1 ? arr[i + 1] : minResult[i + 1]);
        }

        // ��X�̤j�ȴ����᪺���G
        System.out.println("�������᭱�����̤j�ȫ᪺�}�C: " + Arrays.toString(maxResult));

        // ��X�̤p�ȴ����᪺���G
        System.out.println("�������᭱�����̤p�ȫ᪺�}�C: " + Arrays.toString(minResult));
    }
}
