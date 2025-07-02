import java.util.Scanner;
public class hw3
{ 
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
	System.out.println("請輸入一個數值來做交換："); //讓使用者輸入數值來做交換
	int num =scanner.nextInt();
	int x=0; int y=10; int temp=0;     //temp為暫存num的值,一個數值中的數字都是小於10
	temp=num;
 	if(temp>0)  //用來防止使用者輸入0
        {
	    System.out.print(num+"-"+">");
        }
	else
        { 
	    System.out.print("請輸入正確數值");
        }

	while(temp>0)
	{
	   x=temp%10;     //x為從最右邊開始取數值
	   temp/=10;      //消除從最右邊開始的數值，依序消除到整個數值為0
	   
	   if(x!=0)       //如果輸入的數值中有0就不印出
	   {
              System.out.print(x);   
           }
        }
		
    }
}
