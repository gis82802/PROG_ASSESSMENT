import java.util.Scanner;
public class hw3{
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int arr[],arr1[],n;
        int t=0;
        System.out.print("請輸入陣列的大小 (n): ");
        n=sc.nextInt();
        arr=new int[n];
        arr1=new int[n];
        System.out.print("請輸入陣列的元素: ");
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
            arr1[i]=arr[i];
        }

        // 輸出原始陣列
        System.out.print("原始陣列: ");
	for(int i=0;i<arr.length;i++){
            System.out.printf("%d ",arr[i]);
        }
        System.out.printf("\n");


        for(int i=0;i<arr.length;i++){
            t=0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>t) {
                t=arr[j];
                }
            }
            if(i==arr.length-1)t=-1;
            arr[i]=t;

        }     
        System.out.print("max: ");
        for(int i=0;i<arr.length;i++){
            System.out.printf("%d ",arr[i]);
        }

        System.out.printf("\n");

        for(int i=0;i<arr1.length;i++){
            t=arr1[arr1.length-1];
            for(int j=i+1;j<arr1.length;j++){
                if(arr1[j]<t) {
                t=arr1[j];
                }
            }
            if(i==arr1.length-1)t=-1;
            arr1[i]=t;
        } 
        System.out.print("min: ");
        for(int i=0;i<arr1.length;i++){
            System.out.printf("%d ",arr1[i]);
        }
    } 

}
    