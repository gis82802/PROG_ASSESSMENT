import java.util.Scanner;

public class c {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    StringBuilder x = new StringBuilder(input.nextLine());
    input.close();
    x.reverse();
    System.out.println(Integer.parseInt(x.toString()));
  }
}