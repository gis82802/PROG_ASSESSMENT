import java.util.Scanner;

public class hw1011_3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("請輸入一個數字: ");
        int num = scn.nextInt();
        int rNum = 0; 
        while (num != 0) {
            int digit = num % 10; 
            rNum = rNum * 10 + digit; 
            num /= 10;
        }


        System.out.println("反轉後的數字是: " + rNum);
        
        scn.close();
    }
}
