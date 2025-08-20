import java.util.Scanner;

public class aaa {
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
      //  System.out.println(n);
        int a[]=new int[n];
        for(int i=0;i<n;i++){
          a[i]=s.nextInt();
        }
        double sum = 0;
        int min=Integer.MAX_VALUE-1; 
        int max=0;
        for(int i=0;i<n;i++){
           sum+=a[i];
            if (a[i]>max){
                max=a[i];
            }
            if (a[i]<min){
               min=a[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(String.format("%.2f",(sum/n)));
       // System.out.println("sum"+sum);
        
        
    }
}
