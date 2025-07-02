import java.util.Scanner;

public class homework101801 {
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

        
        System.out.print("排序前: ");
        printArray(arr);

       
        int[] arrmin = arr.clone();
        for (int i = 0; i < arrmin.length - 1; i++) {
            for (int j = i + 1; j < arrmin.length; j++) {
                if (arrmin[i] > arrmin[j]) {
                    int temp = arrmin[i];
                    arrmin[i] = arrmin[j];
                    arrmin[j] = temp;
                }
            }
        }
        System.out.print("由小到大排序後: ");
        printArray(arrmin);

        
        int[] arrmax = arr.clone();
        for (int i = 0; i < arrmax.length - 1; i++) {
            for (int j = i + 1; j < arrmax.length; j++) {
                if (arrmax[i] < arrmax[j]) {
                    int temp = arrmax[i];
                    arrmax[i] = arrmax[j];
                    arrmax[j] = temp;
                }
            }
        }
        System.out.print("由大到小排序後: ");
        printArray(arrmax);

        scanner.close();
    }

   
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
