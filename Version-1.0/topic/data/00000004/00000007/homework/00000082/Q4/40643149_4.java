import java.util.Scanner;

/**
 * hw40643149_241018_1
 */
public class hw40643149_241018_4a {

    public static void main(String[] args) {
        System.out.println("輸入矩陣：");
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        //int num = array.length;
        int[][] arrayInt = new int[array.length][array.length];
        arrayInt[0] = convertArrays(array);
        for(int i = 1; i < array.length; i++){
            array = sc.nextLine().split(" ");
            arrayInt[i] = convertArrays(array);
        }
        System.out.println();
       printArray2d(arrayInt);
        
       
      
        //printArray(arrayInt2);
        
    }

    static void printArray(int arrays[]){
        for(int i = 0; i < arrays.length; i++){
            System.out.print(arrays[i]);
            if(arrays.length - i > 1) System.out.print(",");
        }
        System.out.println("");
    }

    static void printArray2d(int arrays[][]){
        for(int i = 0; i < arrays.length; i++){
            for(int j = 0; j < arrays.length; j++){
                System.out.print(arrays[i][j]);
                if(arrays.length - j > 1) System.out.print(",");
            }
            System.out.println("");
        }
    }

    static int[] convertArrays(String arrays[]){
        int[] arraysInt = new int[arrays.length];
        for(int i = 0; i < arrays.length; i++){
            arraysInt[i] = Integer.parseInt(String.valueOf(arrays[i]));
        }
        return arraysInt;
    }
}