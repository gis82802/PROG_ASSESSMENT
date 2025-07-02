import java.util.Arrays;

public class hw2 {
    public static void main(String[] args) {
        int[] arr = {35, 8, 43, 6, 7, 1, 2};

        // ミㄢ挡狦皚┮Τじ程程
        int[] maxResult = new int[arr.length];
        int[] minResult = new int[arr.length];

        // 程じ⊿Τㄤじ砞 -1
        maxResult[arr.length - 1] = -1;
        minResult[arr.length - 1] = -1;

        // 眖计材じ秨﹍矪瞶┕玡筂菌
        for (int i = arr.length - 2; i >= 0; i--) {
            // 璸衡┮Τじ程㎝程
            maxResult[i] = Math.max(arr[i + 1], maxResult[i + 1] == -1 ? arr[i + 1] : maxResult[i + 1]);
            minResult[i] = Math.min(arr[i + 1], minResult[i + 1] == -1 ? arr[i + 1] : minResult[i + 1]);
        }

        // 块程蠢传挡狦
        System.out.println("蠢传じ程皚: " + Arrays.toString(maxResult));

        // 块程蠢传挡狦
        System.out.println("蠢传じ程皚: " + Arrays.toString(minResult));
    }
}
