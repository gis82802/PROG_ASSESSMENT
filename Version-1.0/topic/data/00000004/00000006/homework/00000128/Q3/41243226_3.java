import java.util.Scanner;
public class re {
    public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	System.out.print("輸入欲反轉之數:");
	int a=sc.nextInt();
	int re=0;
	for(;a!=0;a/=10)//a/10可以去除最後一位 
	{
	    int mm= a%10;//抓最後一位
            re=re*10+mm;//e.x.25->5*10+2
        }
	System.out.print("反轉後:"+re);
    }
}