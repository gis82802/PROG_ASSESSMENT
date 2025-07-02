import java.util.Scanner;

public class arrayMax {
    public static void main(String args[]){
        Scanner snc=new Scanner(System.in);
        System.out.println("輸入陣列長度");
        int size=snc.nextInt();

        int array[]=new int[size];

        for(int i=0;i<size;i++){
             array[i]=snc.nextInt();
        }
        System.out.print("排序前:");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n");
    //

    //
        for(int i=0;i<array.length;i++){
            int max=0;
            for(int j=i+1;j<array.length;j++){
               if(array[j]>max){
                max=array[j];
                array[i]=max;
               }
            }
            
        }
        System.out.print("排序後(大):");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
      
    }
}
