import java.util.Scanner;
public class hw1 { 
    public static void main(String args[]) 
    {
	// 讓使用者輸入陣列大小
	System.out.print("請輸入陣列大小：");
	Scanner scanner=new Scanner(System.in);
	int n=scanner.nextInt();
	int arr[]=new int[n];	
	
	//使用者輸入陣列內容
        System.out.print("請輸入內容(需填滿，中間要空格)：");
	for(int i=0;i<n;i++)
	{
	    arr[i]=scanner.nextInt();
	}
	
	//印出未排序的陣列內容
	System.out.print("未排序前：");
	for(int i=0;i<n;i++)
	{
	    System.out.print(arr[i]+" ");
	}
	
	//把陣列內容由小到大做排序
	for(int i=0;i<n-1;i++)
	{
	   for(int j=0;j<n-1;j++)
	   {
		int temp=0;
		if(arr[j]>arr[j+1])
	   	{
		   temp=arr[j];
		   arr[j]=arr[j+1];
		   arr[j+1]=temp;
	   	}
	   }
	}
    	
	//印出排序後的陣列內容
	System.out.println(); //換行
	System.out.print("排序後：");
	for(int i=0;i<n;i++)
	{
	   System.out.print(arr[i]+" ");
	}
    }
}
