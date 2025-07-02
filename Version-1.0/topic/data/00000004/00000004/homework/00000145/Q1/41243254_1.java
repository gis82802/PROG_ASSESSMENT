//filename:test
//function:轉動的桿子
//author:xiao
//date:9/27
//version:11.0.12
public class test
{
  public static void main(String args[])throws Exception
  {
   while(true)
   {
    System.out.print("\r"+"一");
    Thread.sleep(500);
    System.out.print("\r"+"/");
    Thread.sleep(500);
    System.out.print("\r"+"|");
    Thread.sleep(500);
    System.out.print("\r"+"\\");
    Thread.sleep(500);
   }
  }
}

