import java.util.Arrays;

public class hw2 {
    
    public static void main(String[] args) {
        int[] arr = {35, 8, 43, 6, 7, 1, 1, 2};  // 初始化数组
        System.out.println("原數組: " + Arrays.toString(arr));
        
        int[] maxArr = repMax(arr);
        int[] minArr = repMin(arr);
        
        // 最后一个元素替换为-1
        maxArr[maxArr.length - 1] = -1;
        minArr[minArr.length - 1] = -1;

        System.out.println("最大值替換 : " + Arrays.toString(maxArr));
        System.out.println("最小值替換 : " + Arrays.toString(minArr));
    }

    // 用最大值替换
    public static int[] repMax(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[j] > max) {
                    max = arr[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    // 用最小值替换
    public static int[] repMin(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[j] < min) {
                    min = arr[j];
                }
            }
            res[i] = min;
        }
        return res;
    }
}
