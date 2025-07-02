import java.util.Scanner;

public class hw3 { 
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入a的值=");   //讓使用者輸入a、b、c的值
        int a = scanner.nextInt();
        System.out.println("請輸入b的值=");
        int b = scanner.nextInt();
        System.out.println("請輸入c的值=");
        int c = scanner.nextInt();
        
        int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);                //判斷最大值、中間值、以及最小值
        int min = (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);
        int mid = (a != max && a != min) ? a : ((b != max && b != min) ? b : c);
        
        System.out.println("max=" + max + " mid=" + mid + " min=" + min); //顯示最大值、中間值、最小值
        
        scanner.close();
    }
}
