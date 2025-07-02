import java.util.Scanner;
public class hw40643149_241011_2 {
    public static void main(String[] args) {
        int in, BeforeNum, NextNum, iCount = 0;
        for(int i = 10; i <= 10000; i ++){
            in = i;
            BeforeNum = in % 10;
            in = in / 10;
            while (in != 0) {
                NextNum = in % 10;
                in = in / 10;
                if(BeforeNum < NextNum){
                    break;
                }
                BeforeNum = NextNum;
            }
            if(in == 0){
            iCount++;
            }
        }
        System.out.println("到10000有" + iCount+"個");
        System.err.print("輸入數字：");
        Scanner sc = new Scanner(System.in);
        in = sc.nextInt();
        BeforeNum = in % 10;
        in = in / 10;
        while (in != 0) {
            NextNum = in % 10;
            in = in / 10;
            if(BeforeNum < NextNum){
                System.out.println("not well-orderd");
                break;
            }
            BeforeNum = NextNum;
        }
        if(in == 0){
            System.out.println("is well-orderd");
        }
    }
}
