/*
�ɦW:test1
�\��:�i�ۦ��J��Ӯy�ХB��X���I�Z���M���u��{��
�@��:�P����
�Ǹ�:40843237
���:2020/10/05
����:1.0
*/
import java.util.Scanner;
public class test1
{
   public static void main(String args[])
   {
      Scanner scn=new Scanner(System.in);
      double x1,x2,y1,y2,a,b;
      //System.out.println("�п�Jx1�y��:");
      x1=scn.nextDouble();
      //System.out.println("�п�Jy1�y��:");
      y1=scn.nextDouble();
      //System.out.println("�п�Jx2�y��:");
      x2=scn.nextDouble();
      //System.out.println("�п�Jy2�y��:");
      y2=scn.nextDouble();
      System.out.println(Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));
      a=(y1-y2)/(x1-x2);
      b=y1-(a*x1);
      System.out.println(a);
      System.out.println(b);
   }
}