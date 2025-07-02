import java.util.Scanner;

public class HW10183{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("請輸入陣列長度: ");
        int n = scn.nextInt();
        
        int[] arr = new int[n];
    
        System.out.println("請輸入陣列元素: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        
        replace(arr);
        
        System.out.print("處理後的陣列: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        scn.close();
    }

    public static void replace(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            arr[i] = i == arr.length - 1 ? -1 : max;
        }
    }
}
