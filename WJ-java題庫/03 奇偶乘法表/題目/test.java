import java.util.Scanner;
class test {
   public static void main(String args[])
   {
      for(int i=1;i<=9;i+=2)
      {
         for(int j=2;j<=8;j+=2)
         {
            System.out.print(i + "*" + j + "=" + i*j);
            if(j != 8) System.out.print("\t");
         }
         System.out.println();
      }
   }
}