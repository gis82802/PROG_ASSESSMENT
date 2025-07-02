import java.util.Scanner;
public class hw3{
	public static void main(String[] args){
		Scanner snc=new Scanner(System.in);
		System.out.println("請輸入三值:");
		int a=snc.nextInt();
		int b=snc.nextInt();
		int c=snc.nextInt();
		int sum = a + b + c;
        	int min = (a < b ? a : b) < c ? (a < b ? a : b) : c;
        	int max = (a > b ? a : b) > c ? (a > b ? a : b) : c;
        	int mid = sum - min - max;
		System.out.println("最大值 = "+max);
		System.out.println("最小值 = "+min);
		System.out.println("中間值 = "+mid);
	}
}