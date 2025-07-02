import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input an integer number: "); 
        int num = scan.nextInt();
        
        
        int cnt = 0; 
        int cnt1 = 0; 
        int cun = 10; 

       
        int tempNum = num; 

       
        while (tempNum > 0) {
            int a = tempNum % 10; 
            tempNum /= 10; 
            cnt1++;

            if (cun > a) {
                cnt++; 
            }
            cun = a; 
        }

      
        if (cnt == cnt1 ) { 
            System.out.printf("%d is a well-order number\n", num);
        } else {
            System.out.printf("%d is not a well-order number\n", num);
        }

        scan.close(); 
    }
}
