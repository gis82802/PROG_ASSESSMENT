import java.util.Stack;
import java.util.Scanner;

public class t3 {
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
        Object[] maxarr = arr.clone();
        Object[] minarr = arr.clone();
        System.out.print("ori: ");
        for (Object x : arr)
            System.out.print(x + " ");
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            maxarr[i] = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if ((int) (maxarr[i]) < (int) (arr[j])) {
                    maxarr[i] = arr[j];
                }
            }
        }
        maxarr[maxarr.length - 1] = -1;
        System.out.print("max: ");
        for (Object x : maxarr)
            System.out.print(x + " ");
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            minarr[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if ((int) (minarr[i]) > (int) (arr[j])) {
                    minarr[i] = arr[j];
                }
            }
        }
        minarr[minarr.length - 1] = -1;
        System.out.print("min: ");
        for (Object x : minarr)
            System.out.print(x + " ");
    }
}
