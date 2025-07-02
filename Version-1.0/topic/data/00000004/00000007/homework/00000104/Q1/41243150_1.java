import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] s = new int[n];
        
        for (int i = 0; i < n; i++) {
            s[i] = scn.nextInt();
        }
        
        System.out.println("Original array:");
        for (int value : s) {
            System.out.printf("%d ", value);
        }
        System.out.println();

        for (int b = 0; b < s.length - 1; b++) { 
            for (int j = 0; j < s.length - 1 - b; j++) {
                if (s[j] > s[j + 1]) { 
                    int temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array:");
        for (int value : s) {
            System.out.printf("%d ", value);
        }
        System.out.println();

        scn.close(); 
    }
}
