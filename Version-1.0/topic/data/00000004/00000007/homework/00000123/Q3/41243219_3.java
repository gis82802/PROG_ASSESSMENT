import java.util.Scanner;
public class hw183{

    //public static int max(int a, int b)

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input Array Size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int[] arr1 = new int[size];
        System.out.print("Input Array: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
            arr1[i] = arr[i];
        }

        int mn = arr[size - 1];
        arr[size - 1] = -1;
        for(int i = size - 2; i >= 0; i--){
            int tmp = mn > arr[i] ? mn : arr[i];
            arr[i] = mn;
            mn = tmp;
        }
        System.out.println("Max Replace: ");
        for(int x: arr){
            System.out.print(x + " ");
        }System.out.println();

        mn = arr1[size - 1];
        arr1[size - 1] = -1;
        for(int i = size - 2; i >= 0; i--){
            int tmp = mn < arr1[i] ? mn : arr1[i];
            arr1[i] = mn;
            mn = tmp;
        }
        System.out.println("Min Replace: ");
        for(int x: arr1){
            System.out.print(x + " ");
        }
    }
}