import java.util.Scanner;
public class hw40643149_241011_3 {
    public static void main(String[] args) {
        int in;
        int out;
        System.err.print("輸入數字：");
        Scanner sc = new Scanner(System.in);
        in = sc.nextInt();
        for(out = 0; in > 0; ){
            out = (out * 10) + (in % 10);
            in /= 10;
        }
        System.out.println(out);
    }
}
