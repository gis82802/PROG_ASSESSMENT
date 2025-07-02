import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class J_1018_01 {
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<>(); //可動陣列
		
		System.out.print(":");
		while(sn.hasNext()){ //used EOF
			array.add(sn.nextInt());
		}
		
		sn.close(); //Stop used Scanner.
		
		System.out.println("");
		System.out.println("before:"+array);
		//int i = in.length;
		Collections.sort(array); //排序大小
		
		System.out.println("after :"+array);
	}
}
