
import java.util.Scanner;

public class ArrayStats {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);  
        
        int n = input.nextInt();
        int[] a = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        
        int max=a[0],min=a[0],sum=a[0];
        for (int i = 1; i < n; i++) {
            if(a[i]>max)max=a[i];
            if(a[i]<min)min=a[i];
           sum+=a[i];
        }
        double avg=(double)sum/n;
        
        System.out.printf("%d\n%d\n%.2f\n", max,min,avg);
        
        input.close(); 
    }
}
