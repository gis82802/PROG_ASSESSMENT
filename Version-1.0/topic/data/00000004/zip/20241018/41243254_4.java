//app6_test4
//filename:app6_test4
//function:用java讓使用者輸入一個n*n陣列n<=4並且輸出陣列讓使用者輸入二個整數i,j將會去掉陣列第i列和第j行後的新矩陣印出並計算新矩陣的行列式印出
//author:xiao
//date:10/18
//version:11.0.12

import java.util.Scanner;
public class app6_test4
{
  public static void main(String args[])
  {
    Scanner scn=new Scanner(System.in);
    int n=0;
    //輸入n為幾乘幾的陣列並限定範圍
    while(true)
    {
    System.out.print("陣列為n*n輸入您的n(<=4)為:");
    n=scn.nextInt();
    if(n!=0&&n<=4)
      break;
    else
      System.out.println("輸入錯誤");
    }
    
    // 建立一個 n*n 的陣列
    int[][] arr = new int[n][n];

    // 輸入陣列的值
    System.out.println("請輸入 " + n + "x" + n + " 陣列的數值：");
    for (int i = 0; i < n; i++) 
    {
      for (int j = 0; j < n; j++) 
      {
        arr[i][j] = scn.nextInt();
      }
    }

    // 輸出陣列
    System.out.println("你輸入的陣列是：");
    for (int i = 0; i < n; i++) 
    {
      for (int j = 0; j < n; j++) 
      {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println(); // 換行
    }

    // 請使用者輸入要去掉的列 i 和 行 j
     int row, col;
     do {
          System.out.print("請輸入要去掉的第 i 列 (1 <= i <= " + n + "): ");
          row = scn.nextInt() - 1;  // 用 -1 調整成陣列索引
        } while (row < 0 || row >= n);

     do {
          System.out.print("請輸入要去掉的第 j 行 (1 <= j <= " + n + "): ");
          col = scn.nextInt() - 1;  // 用 -1 調整成陣列索引
        } while (col < 0 || col >= n);

     // 創建新矩陣並去掉第 i 列和第 j 行
     int newSize = n - 1;
     int[][] newMatrix = new int[newSize][newSize];
     int r = 0, c = 0;

     for (int i = 0; i < n; i++) 
     {
       if (i == row) continue; // 跳過指定的列
       c = 0;
       for (int j = 0; j < n; j++) 
       {
         if (j == col) continue; // 跳過指定的行
         newMatrix[r][c] = arr[i][j];
         c++;
       }
       r++;
     }

     // 輸出新矩陣
     System.out.println("去掉第 " + (row + 1) + " 列和第 " + (col + 1) + " 行後的新矩陣：");
     for (int i = 0; i < newSize; i++) 
     {
       for (int j = 0; j < newSize; j++)
       {
         System.out.print(newMatrix[i][j] + " ");
       }
     System.out.println(); // 換行
     }

     // 計算新矩陣的行列式（只處理 2x2 矩陣）
     if (newSize == 2) 
     {
       int determinant = (newMatrix[0][0] * newMatrix[1][1]) - (newMatrix[0][1] * newMatrix[1][0]);
       System.out.println("新矩陣的行列式是：" + determinant);
     } else 
           {
            System.out.println("目前僅支援計算 2x2 矩陣的行列式。");
           }

    
  }
 



}
