import java.util.Scanner;

class test {
    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        
        System.out.print("請輸入資料筆數 n：");
        int n = sn.nextInt();
        int[] arr = new int[n];
        
        System.out.println("請輸入 " + n + " 筆整數：");
        for(int i = 0; i < n ; i++){
            arr[i] = sn.nextInt();
        }
        
        int max = arr[0], min = arr[0], sum = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
            sum += arr[i];
        }
        double avg = (double)sum / n;
        
        System.out.printf("最大值：%d\n最小值：%d\n平均值：%.2f\n", max, min, avg);
        
        sn.close();
    }
}