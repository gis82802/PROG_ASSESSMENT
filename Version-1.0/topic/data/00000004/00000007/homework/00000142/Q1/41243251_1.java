import java.util.Scanner;

public class hw1_1018 {
    public static void main(String[] args){
	Scanner scn=new Scanner(System.in);
	int x,n,temp;
	System.out.println("輸入陣列大小:");
	x = scn.nextInt();
	int[] a = new int[x];
	System.out.println("輸入陣列內容:");
	for(int i=0;i<a.length;i++){
	   a[i]=scn.nextInt();
	}
	System.out.println("排序前:");
	for(int i=0;i<a.length;i++){
	   System.out.print(a[i]+", ");
	}
	for(int i=0;i<a.length;i++){
	   n=i;
	   for(int j=n;j<a.length;j++){
	       if(a[n]<a[j]){
		  temp=a[n];
		  a[n]=a[j];
		  a[j]=temp;
	       }
	   }
	}
	System.out.println("\n排序後:");
	for(int i=0;i<a.length;i++){
	   System.out.print(a[i]+", ");
	}
    }
}
