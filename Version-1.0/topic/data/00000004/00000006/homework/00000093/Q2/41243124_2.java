import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("輸入數字: ");
        int n = sc.nextInt();
        System.out.println("輸入: " + n);
        
        int prev = 10;
        boolean isOrdered = true;        
        while (n > 0) {
            int curr = n % 10;            
            if (curr >= prev) { 
                isOrdered = false;
                break;
            }
            
            prev = curr;  
            n /= 10;  
        }
       
        System.out.println(isOrdered ? "有序" : "無序");
        
        sc.close();
    }
}
