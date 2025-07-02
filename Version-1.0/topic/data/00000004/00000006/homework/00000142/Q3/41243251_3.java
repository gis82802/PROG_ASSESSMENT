import java.util.Scanner;

public class hw3_1011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        System.out.print("輸入數字：");
        int num = scanner.nextInt();
	int x=0,y;
        while (num!=0) {
	     y=num%10;    //取得尾數
	     x=x*10+y;	  //將數字*10後，再加上新取得的尾數
             num=num/10;  //去除尾數
        }
        System.out.println("反轉後: "+x);
    }
}
