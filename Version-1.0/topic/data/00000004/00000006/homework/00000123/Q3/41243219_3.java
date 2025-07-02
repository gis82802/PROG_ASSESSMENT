import java.util.Scanner;

public class hw3{
	public static void main(String args[]){
		String s;
		int n;
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == '0')continue;
			System.out.print(s.charAt(i));	
		}
	}
}