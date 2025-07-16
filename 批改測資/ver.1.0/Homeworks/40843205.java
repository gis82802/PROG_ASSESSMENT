//app2 輸入不同資料型態的資料
import java.util.Scanner;
public class app2 {
  public static void main(String args[]) {
    Scanner scn=new Scanner(System.in);
    byte b; short s;
    int i; char c;
    long l; float f; double d;

    b=scn.nextByte();
    s=scn.nextShort();
    i=scn.nextInt();
    c=scn.next().charAt(0);
    l=scn.nextLong();
    f=scn.nextFloat();
    d=scn.nextDouble();

    System.out.println(b);
    System.out.println(s);
    System.out.println(i);
    System.out.println(c);
    System.out.println(l);
    System.out.println(f);
    System.out.println(d);
  }
}