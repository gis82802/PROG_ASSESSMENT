import java.util.Scanner;
public class hw1
{
   public static void main(String args[])
   {   
       Scanner scanner=new Scanner(System.in);
       System.out.printf("請輸入陣列長度:");
       int length=scanner.nextInt();
       int a[] = new int[length];
       System.out.printf("請輸入陣列元素:");
       for (int i=0;i<length;i++)
       {
       a[i]=scanner.nextInt();
       }
       System.out.printf("排序前: a = { ");
       for (int i=0;i<length-1;i++)
       {
       System.out.printf(a[i]+", ");
       }
       System.out.printf(a[length-1]+"}\n");
       for (int i=0;i<length;i++)
       {   
           int index=i;
           for (int j=i+1;j<length;j++)
           {
            if (a[j]<a[index]){index=j;}
           }
           int temp=a[i];
           a[i]=a[index];
           a[index]=temp;
       }
       System.out.printf("排序後: a = { ");
       for (int i=0;i<length-1;i++)
       {
       System.out.printf(a[i]+", ");
       }
       System.out.printf(a[length-1]+"}\n");

   }
}