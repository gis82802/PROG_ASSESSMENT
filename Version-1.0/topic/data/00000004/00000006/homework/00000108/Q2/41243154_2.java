import java.util.Scanner;

public class J_1011_01 {
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        
        System.out.print(":");
        int in      = sn.nextInt();
        int a       = in;
        int len     = 0;
        int val     = 9;
        boolean ans = true;
        while(ans){
            if(a%10 <= val)val = a%10;
            else ans = false;
            if(a == 0)break;
            len++;
            a /= 10;
        }
		
        System.out.print("\n");
        if(ans) System.out.printf("%d is well-ordered unmber.\n",in);
        else    System.out.printf("%d is not well-ordered unmber.\n",in);
        
    }
}
