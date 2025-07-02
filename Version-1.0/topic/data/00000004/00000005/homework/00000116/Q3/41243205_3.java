import java.util.Scanner;
public class ex4{
	public static void main(String args[]){
		//取得使用者輸入
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		System.out.printf("輸入三整數找大中小\n");
		System.out.printf("輸入第一個數: ");
		a = sc.nextInt();
		System.out.printf("輸入第二個數: ");
		b = sc.nextInt();
		System.out.printf("輸入第三個數: ");
		c = sc.nextInt();
		//找最大值
		int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		System.out.printf("最大值: %d\n",max);
		//找中值
		int middle = a > b ? (a > c ? (c > b ? c : b) : a) : (b > c ? (c > a ? c : a) : b);
		System.out.printf("中間值: %d\n",middle);
		//找最小值
		int min = a < b ? (a < c ? a : c) : (b < c ? b : c);
		System.out.printf("最小值: %d",min);
	}
}