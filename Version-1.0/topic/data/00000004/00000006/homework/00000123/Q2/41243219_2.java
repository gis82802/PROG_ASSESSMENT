import java.util.Scanner;

public class hw2{
	public static void main(String args[]){
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		boolean flag = true;
		for(int i = 0; i < s.length() - 1; i++){
			if(s.charAt(i) >= s.charAt(i + 1)){
				flag = false;
				break;
			}
		}
		if(flag)System.out.println(s + " is a well-ordered number.");
		else System.out.println(s + " is not a well-ordered number.");
		

		System.out.println("##############################");

		flag = true;
		int ans = 0;
		for(int k = 1; k <= 10000; k++){
			flag = true;
			s = Integer.toString(k);
			for(int i = 0; i < s.length() - 1; i++){
				if(s.charAt(i) >= s.charAt(i + 1)){
					flag = false;
					break;
				}
			}
			if(flag) ans++;
		}
		System.out.println(ans);
	}
}