import java.util.Scanner;

public class test3{
    
    public static void main(String[] args){
        int a,b,c;
        int val_a=0;
        int val_b=0;
        int val_c=0;
        
        char[] stringline = new char[3];
        Scanner s = new Scanner(System.in);
        System.out.println("輸入3個值");
        a= s.nextInt();
        b= s.nextInt();
        c= s.nextInt();

        val_a = (a>b)?++val_a:val_a;
        val_a = (a>c)?++val_a:val_a;

        val_b = (b>a)?++val_b:val_b;
        val_b = (b>c)?++val_b:val_b;

        val_c = (c>b)?++val_c:val_c;
        val_c = (c>a)?++val_c:val_c;

        System.out.println("a:"+val_a);
        stringline[val_a] = 'a';
        System.out.println("b:"+val_b);
        stringline[val_b] = 'b';
        System.out.println("c:"+val_c);
        stringline[val_c] = 'c';

        System.out.println("Max: "+stringline[2]);
        System.out.println("Middle: "+stringline[1]);
        System.out.println("Min: "+stringline[0]);
    }
    
}