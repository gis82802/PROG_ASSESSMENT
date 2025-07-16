/* fileName:app1_2
function:Let user keyin mutiple types of data
ID:40743126 \u79e6\u656c\u8ed2
name:秦敬軒
*/	
import java.util.Scanner;

public class app1_2{
	public static void main(String args[]){
		int in1;
		int in2;
		
	Scanner	scanner = new Scanner(System.in);
		//System.out.println("請輸入兩個位元組(byte) 用空白分開:");
		in1=scanner.nextByte();
		//in2=scanner.nextByte();
		System.out.println(in1);
		//System.out.println("您剛剛輸入的數字為:"+in1+" "+in2+"\n");
		
		scanner = new Scanner(System.in);
		//System.out.println("請輸入兩個短整數(Short) 用空白分開:");
		in1=scanner.nextShort();
		//in2=scanner.nextShort();
		System.out.println(in1);
		//System.out.println("您剛剛輸入的數字為:"+in1+" "+in2+"\n");
		
		scanner = new Scanner(System.in);
		//System.out.println("請輸入兩個整數(int) 用空白分開:");
		in1=scanner.nextInt();
		in2=scanner.nextInt();
		System.out.println(in1);
		//System.out.println("您剛剛輸入的數字為:"+in1+" "+in2+"\n");
		
		
		scanner = new Scanner(System.in);
		//System.out.println("請輸入字元(Char) 用空白分開:");
		in1=scanner.next().charAt(0); 
		//in2=scanner.next().charAt(0); 
		System.out.println(Integer.toString(in1));
		//System.out.println("您剛剛輸入的字元編碼為:"+Integer.toString(in1)+" "+Integer.toString(in2)+"\n");
		
		long lin1,lin2;
		scanner = new Scanner(System.in);
		//System.out.println("請輸入兩個長整數(long) 用空白分開:");
		lin1=scanner.nextLong();
		//lin2=scanner.nextLong();
		System.out.println(lin1);
		//System.out.println("您剛剛輸入的數字為:"+lin1+" "+lin2+"\n");
		
		float fin1,fin2;
		scanner = new Scanner(System.in);
		//System.out.println("請輸入兩個浮點數(float) 用空白分開:");
		fin1=scanner.nextFloat();
		//fin2=scanner.nextFloat();
		System.out.println(fin1);
		//System.out.println("您剛剛輸入的數字為:"+fin1+" "+fin2+"\n");
		
		double din1,din2;
		scanner = new Scanner(System.in);
		//System.out.println("請輸入兩個雙精度浮點數(double) 用空白分開:");
		din1=scanner.nextDouble();
		//din2=scanner.nextDouble();
		System.out.println(din1);
		//System.out.println("您剛剛輸入的數字為:"+din1+" "+din2+"\n");
	}
		
		
}