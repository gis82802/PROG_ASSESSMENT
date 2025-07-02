import java.util.Scanner;

public class J_1018_03 {
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		
		System.out.print("array size(n):");
		int n = sn.nextInt();
		int array[] = new int[n];
		System.out.print(":");
		for(int i=0;i<n;i++){
			array[i] = sn.nextInt();
		}
		sn.close(); //Stop used Scanner.
		
		System.out.println("");
		System.out.print("before:");
		for(int i=0;i<n;i++){
			System.out.print(array[i]);
			if(i+1 >= n)System.out.print("\n");
			else        System.out.print(" ");
		}
		
		System.out.println("");
		System.out.print("after :");
		for(int i=0;i<n;i++){
			int max = -1;
			for(int j=i+1;j<n;j++){
				if(array[j] >= max)max = array[j];
			}
			System.out.print(max);
			if(i+1 >= n)System.out.print("\n");
			else        System.out.print(" ");
		}
	}
}
