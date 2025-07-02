import java.util.Scanner;
public class hw1{
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int arr[],n;
        System.out.printf("請輸入陣列的大小 (n): ");
        n=sc.nextInt();
        arr=new int[n];
        System.out.printf("請輸入陣列的元素:");
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();

        // 輸出原始陣列
        System.out.println("原始陣列:");
	for(int i=0;i<arr.length;i++){
            System.out.printf("%d ",arr[i]);
        }

        System.out.printf("\n");

        // 排序
        int t;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]) {
                t=arr[j];
                arr[j]=arr[i];
                arr[i]=t;
                }
            }
            

        }
        System.out.println("排序後的陣列:");
        for(int i=0;i<arr.length;i++){
            System.out.printf("%d ",arr[i]);
        }
    } 

}
    