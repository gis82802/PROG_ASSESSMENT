//app6_test1
//filename:app6_test1
//function:輸入一維陣列進行排序
//author:xiao
//date:10/18
//version:11.0.12

import java.util.Scanner;
public class app6_test1
{
  public static void main(String args[])
  { 
    Scanner scanner = new Scanner(System.in);
   
     
    //輸入陣列內的數字
    int arr[]=new int[5];
    System.out.print("輸入五個數字:");
    for(int i=0;i<=4;i++)
    {
      arr[i]=scanner.nextInt(); 
    }


    //輸出輸入的數字
    System.out.print("您輸入的數字為:");
    for (int i=0;i<=4;i++) 
    {
      System.out.print(arr[i]+" ");
    }
    for(int i=0;i<=4;i++)
    {
      for(int j=i+1,num=0;j<=4;j++)
      {
        if(arr[i]<arr[j])
        {
          num=arr[j];
          arr[j]=arr[i];
          arr[i]=num;
        }
      }
    }


    //輸出排序後的數字
    System.out.println();
    System.out.print("排序後的數字為:");
    for (int i=0;i<=4;i++) 
    {
      System.out.print(arr[i]+" ");
    }

  }
}