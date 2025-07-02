import java.util.Scanner;
public class hwb{
    public static void main(String[] avgs){
        Scanner s=new Scanner(System.in);
        System.out.print("請輸入一個整數");
        int n=s.nextInt();// 讀取使用者輸入的整數
        int sum=0;//計算有多少well-order number
        int j=1;//判斷是不是well-order number
        int k=n;//存輸入的整數以供之後輸出
        while(n>0){//判斷是不是well-order number的迴圈
            if(n%10>(n/10)%10){
                n=n/10;
            }
            else{
                j=0;
                break;
            }
        }
        //while end
        //判斷後輸出
        if(j==1){
            System.out.println(k+" is a well-order number");
        }
        else{
            System.out.println(k+" is not a well-order number");
        }
        //判斷有多少個well-order number迴圈
        for(int i=1;i<=100000;i++){
            k=i;
            while(k>0){
                if(k%10>(k/10)%10){
                    k=k/10;
                    j=1;
                }
                else{
                    j=0;
                    break;
                }
            }
            if(j==1){
                sum+=1;
            }
        }
        System.out.print("1到100000總共有"+sum+"個 well-order number");
        s.close();
    }
}