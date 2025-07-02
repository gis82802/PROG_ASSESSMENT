import java.util.Scanner;

public class homework101803 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int big;

        System.out.println("請輸入陣列大小:");
        big=scanner.nextInt();



        int[] arr = new int[big]; 
        
        System.out.println("請輸入"+big+"個整數：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        
        System.out.print("原始陣列: ");
        printArray(arr);

        
        int[] maxArr = replaceWithMax(arr);
        System.out.print("以後面的最大值取代後: ");
        printArray(maxArr);

        
        int[] minArr = replaceWithMin(arr);
        System.out.print("以後面的最小值取代後: ");
        printArray(minArr);

        scanner.close();
    }

    
    public static int[] replaceWithMax(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    
    public static int[] replaceWithMin(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
            }
            result[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return result;
    }

    
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
