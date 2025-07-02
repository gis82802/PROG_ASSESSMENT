import java.util.Scanner;

public class J_test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input size: ");
        int size = scanner.nextInt();

        int[] a = new int[size];
        

        System.out.println("input array:");
        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }
        
        System.out.println("input is:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        System.out.println("result:");
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        scanner.close();
    }
}