import java.util.Scanner;

public class hw3_1018 {
    public static void main(String[] args){
	Scanner scn=new Scanner(System.in);
	int x;					
	System.out.println("輸入陣列大小:");
	x = scn.nextInt();
	int[] max = new int[x];
	int[] min = new int[x];
	int b;
	System.out.println("輸入陣列內容:");
	for(int i=0;i<max.length;i++){	
	   max[i]=scn.nextInt();
	   min[i]=max[i];
	}
	System.out.println("陣列內容:");
	for(int i=0;i<max.length;i++){
	   System.out.print(max[i]+", ");
	}
					/*看最大值*/
	for(int i=0;i<max.length;i++){
	   b=i;
	   for(int j=b+1;j<max.length;j++){
	       if(max[b+1]<=max[j]){
		  if(max[b]<=max[j]){
		     max[b]=max[j];
		  }
	       }
	   }
	   if(i==max.length-1){
	       max[i]=-1;	
	   }
	}
	System.out.println("\nMax:");
	for(int i=0;i<max.length;i++){
	   System.out.print(max[i]+", ");
	}
	
					/*看最小值*/
	for(int i=0;i<min.length;i++){
	   b=i;
	   for(int j=b+1;j<max.length;j++){
	       if(min[b+1]>=min[j]){
		  if(min[b]>=min[j]){
		     min[b]=min[j];
		  }
	       }
	   }
	   if(i==min.length-1){
	       min[i]=-1;	
	   }
	}
	System.out.println("\nMin:");
	for(int i=0;i<min.length;i++){
	   System.out.print(min[i]+", ");
	}
    }
}
