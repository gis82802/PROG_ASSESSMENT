import java.util.Scanner;
import java.util.Arrays;

/**
 * hw40643149_241018_1
 */
public class hw40643149_241018_1 {

    public static void main(String[] args) {
        System.out.println("輸入任意數列：");
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int[] arrayInt = new int[array.length];
        for(int i = 0; i < array.length; i++){
            arrayInt[i] = Integer.parseInt(String.valueOf(array[i]));
        }
        printArray(arrayInt);

        Arrays.sort(arrayInt);
        
        printArray(arrayInt);
        
    }
    static void printArray(int arrays[]){
        for(int i = 0; i < arrays.length; i++){
            System.out.print(arrays[i]);
            if(arrays.length - i > 1) System.out.print(",");
        }
        System.out.println("");
    }
}