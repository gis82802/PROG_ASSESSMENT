import java.util.Scanner;

public class J_1011_01 {
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        
        System.out.print(":");
        int in      = sn.nextInt();
        int a       = in;
        int len     = 0;
        int val     = 9;
		int out     = 0;
        boolean ans = true;
        while(ans){
            if(a == 0)break;
			out *= 10;
            out += a%10;
            len++;
            a   /= 10;
        }
		
        System.out.print("\n");
        System.out.printf("rever:%d",out);
        
    }
}
