import java.util.Scanner;

public class homework3_3 {
    public static void main(String[] args) {
        int[] x = new int[5];
        int a = 0;
        int b=0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個數字: ");
        int input = scanner.nextInt();

        while (input != 0) {
            x[a] = input % 10;
            a++;
            input /= 10;
        }

        for(int c=1;c<a;c++)
        {
            if(x[c-1]<x[c])
            {
                System.out.print("it is not a well-ordered number");
                b++;
                break;
            }
        }
        if(b==0) System.out.print("it is a well-ordered number");

        scanner.close();
    }
}

