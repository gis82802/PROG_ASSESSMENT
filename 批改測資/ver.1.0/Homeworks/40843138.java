/* 
   作業 2
   用途:輸入任意型態的資料
   姓名:張敬典
   學號:40843138
   日期:2020/10/5
*/
import java.util.Scanner;
public class text2
{   
   public static void main(String args[])
   {
      Scanner scn = new Scanner(System.in);
      String date;

      //System.out.print("請輸入資料 ");
      date = scn.nextLine();
      System.out.print(date);
   }
}