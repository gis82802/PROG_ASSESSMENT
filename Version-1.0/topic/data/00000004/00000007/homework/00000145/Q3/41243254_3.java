//app6_test3
//filename:app6_test3
//function:輸入一維陣列將陣列內容每個元素的值以它之後的最大數值所取代
//author:xiao
//date:10/18
//version:11.0.12

import java.util.Scanner;
public class app6_test3
{
  public static void main(String args[])
  {
    Scanner scanner = new Scanner(System.in);
    int arr[]=new int[7];

    
    //輸入需要排序的七個數字
    System.out.print("輸入七個數字:");
    for(int i=0;i<=6;i++)
    {
      arr[i]=scanner.nextInt(); 
    }


    //輸出轉換後的陣列
    System.out.print("轉換後為:"); 
    for(int i=0;i<=6;i++)
    {
      for(int j=i+1,num=0;j<=6;j++)
      {
        if(num<arr[j])
        { 
          num=arr[j];
          arr[i]=num;
        }
      }
    }
    arr[6]=-1;//將最後一位數轉為-1
    for (int i=0;i<=6;i++) 
    {
      System.out.print(arr[i]+" ");
    }
  }
}