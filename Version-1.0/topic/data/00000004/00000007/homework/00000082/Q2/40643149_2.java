import java.util.Scanner;

/**
 * hw40643149_241018_1
 */
public class hw40643149_241018_2 {

    public static void main(String[] args) {
        System.out.println("輸入任意數列：");
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int[] arrayInt1 = convertArrays(array);
        int[] arrayInt2 = convertArrays(array);
        int Num;
        Num = arrayInt1[array.length - 1];
        for(int i = array.length - 1; i > -1; --i){
            
            if(arrayInt1[i] < Num){
                arrayInt1[i] = Num;
            }
            else{
                int temp = arrayInt1[i];
                arrayInt1[i] = Num;
                Num = temp;
            }
            arrayInt1[array.length - 1] = -1;
        }
        System.out.println("大：");
        printArray(arrayInt1);

        for(int i = array.length - 1; i > -1; --i){
            
            if(arrayInt2[i] > Num){
                arrayInt2[i] = Num;
            }
            else{
                int temp = arrayInt2[i];
                arrayInt2[i] = Num;
                Num = temp;
            }
            arrayInt2[array.length - 1] = -1;
        }
        System.out.println("小：");
        printArray(arrayInt2);
        
    }
    static void printArray(int arrays[]){
        for(int i = 0; i < arrays.length; i++){
            System.out.print(arrays[i]);
            if(arrays.length - i > 1) System.out.print(",");
        }
        System.out.println("");
    }
    static int[] convertArrays(String arrays[]){
        int[] arraysInt = new int[arrays.length];
        for(int i = 0; i < arrays.length; i++){
            arraysInt[i] = Integer.parseInt(String.valueOf(arrays[i]));
        }
        return arraysInt;
    }
}