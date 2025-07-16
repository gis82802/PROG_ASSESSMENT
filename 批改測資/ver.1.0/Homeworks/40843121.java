/*
   作業2

   使用者輸入不同原始資料型態的資料
   (byte, short, int, char, long, float, dobule)

   40843121
   衣庭磊
   2020/10/5
*/
import java.util.Scanner;
public class HW_2
{
   public static void main(String[] args)
   {
      Scanner scn=new Scanner(System.in);
      String data;

      //System.out.print("請輸入資料! ");
      data=scn.nextLine();
   
      System.out.print(data);
   }
}