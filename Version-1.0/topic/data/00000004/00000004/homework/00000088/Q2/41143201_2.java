import java.util.Scanner;
public class un
{
public static void main(String[] args)
{
    Scanner scn=new Scanner(System.in,"UTF-8");
    String name=scn.nextLine();
    for(int i=0;i<name.length();i++){
        System.out.println(name.charAt(i)+":");
    }
System.out.println(name);
}
}