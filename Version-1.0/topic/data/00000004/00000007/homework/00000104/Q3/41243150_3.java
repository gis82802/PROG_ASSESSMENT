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

        for (int b = 0; b < s.length -1; b++) { 
            int max=s[b+1];
            for(int c=b;c<s.length;c++){
                if (s[c]>max){
                    max=s[c];
                }
            }
            s[b]=max;
        }

        System.out.println("Sorted array:");
        for (int value : s) {
            System.out.printf("%d ", value);
        }
        System.out.println();

        scn.close(); 
    }
}
