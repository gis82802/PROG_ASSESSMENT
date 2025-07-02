import java.util.Scanner;
public class sort {
    public static void main(String args[]){
        
        Scanner snc=new Scanner(System.in);
        System.out.println("輸入陣列長度");
        int size=snc.nextInt();

        int array[]=new int[size];

        for(int i=0;i<size;i++){
             array[i]=snc.nextInt();
        }
//
        System.out.print("排序前:");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n");
        int m=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    m=array[i];
                    array[i]=array[j];
                    array[j]=m;

                }
            }
        }
        //
        System.out.print("排序後:");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}
