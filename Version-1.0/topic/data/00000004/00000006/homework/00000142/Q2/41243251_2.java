import java.util.Scanner;
import java.lang.Math;
public class hw2_1011 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		long num,a=0,b=0,Max=100000,sum=0;
		System.out.print("(a)\n請輸入數字:");
		num = scn.nextInt();
		while(num>0){
		     a=num%10;			//取數的最後一位
		     num/=10;			//減去最後一位
		     b=num%10;			//取數的倒數第二位
		     if(a<=b){			//如果不是well-ordered number就離開迴圈
		  	System.out.println("不是well-ordered number");
			break;
		     }
		}
		if(a>b)				//確認是不是well-ordered number
		System.out.println("是well-ordered number");	
		System.out.println("-------------------------\n(b)"); 
		while(Max>0){
		     num=Max;
		     while(num>0){
		         a=num%10;
		         num/=10;
		         b=num%10;
		         if(a<=b){		
			    break;
		         }
		     }
		     if(a>b){
			sum++;			//為well-ordered number就+1
		     }
		     Max--;
		}
		System.out.println("100000內有"+sum+"個well-ordered number");
	}
}