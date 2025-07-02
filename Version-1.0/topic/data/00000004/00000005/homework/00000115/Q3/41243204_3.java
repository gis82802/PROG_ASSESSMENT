/*
    filename:hw3_4
    function:比較大小
    author:41243204
    datetime:2024/10/4
    version:1.0
*/
import java.util.Scanner;
 public class hw3_4
 {
  public static void main(String args[])
  {
   Scanner scanner = new Scanner (System.in);

   System.out.println("請輸入第一個數字");
   int firstnumber = scanner.nextInt();
   System.out.println("請輸入第二個數字");
   int secondnumber = scanner.nextInt();
   System.out.println("請輸入第三個數字");
   int thirdnumber = scanner.nextInt();
   
   int max = (firstnumber>secondnumber)?(firstnumber>thirdnumber?firstnumber:thirdnumber):(secondnumber>thirdnumber?secondnumber:thirdnumber);
   int min = (firstnumber<secondnumber)?(firstnumber<thirdnumber?firstnumber:thirdnumber):(secondnumber<thirdnumber?secondnumber:thirdnumber);
   int mid = (firstnumber != max && firstnumber != min)?firstnumber:(secondnumber != max && secondnumber != min)?secondnumber:thirdnumber;

   System.out.println("最大數為:"+max);
   System.out.println("中間數為:"+mid);
   System.out.println("最小數為:"+min);

   scanner.close();
   }
}
//此程式變數名稱皆有意義，方便閱讀。
