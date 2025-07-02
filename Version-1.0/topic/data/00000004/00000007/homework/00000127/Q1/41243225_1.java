
/**
 * t1
 */
import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        String str = new String();
        Scanner input = new Scanner(System.in);
        System.out.print("Input a One-Dimensional Array (','split): ");
        str = input.nextLine();
        input.close();
        Stack<Integer> stack = new Stack<Integer>();
        for (String i : str.split(",")) {
            stack.push(Integer.valueOf(i));
        }
        Object[] arr = stack.toArray();
        System.out.print("Before sort: ");
        for (Object x : arr)
            System.out.print(x + " ");
        Arrays.sort(arr);
        System.out.println();
        System.out.print("After sort: ");
        for (Object x : arr)
            System.out.print(x + " ");
    }

}