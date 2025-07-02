import java.util.Scanner;
public class hwb{
    
    public static void main(String[] args ){//第一題的A部分
    Scanner s = new Scanner(System.in);
    //a部分開始
   System.out.println("輸入你的三角高度");
    int h,n;
    h=s.nextInt();
    System.out.println("下三角");
    for(int i=1;i<=h;i++){
        for(int j=1;j<=i;j++){
            System.out.print("*");    
        }
        System.out.print("\n");
    }
    System.out.println("上三角");
        for (int i = h; i >= 1; i--) {
            // 打印空格
            for (int k = i; k < h; k++) {
                System.out.print(" ");
            }
            // 打印星号
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            
            System.out.print("\n");
        }
    //a部分結束
    //b部分開始
    int num=1;
    System.out.println("輸入你的數字：");
    n=s.nextInt();
    for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                if(num==n)
                System.out.print("輸入的數字在金字塔的二維座標為：["+i+"]["+j+"]");
                num++;  // 每打印一個數字，遞增
            }
        }
    }
}
