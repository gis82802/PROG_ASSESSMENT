import java.util.Scanner;
public class hw3{
    public static void main(String[] args){
        int iinput,itest,ia=0;
        Scanner scn=new Scanner(System.in);
        System.out.print("請輸入一串數字:");
        iinput=scn.nextInt();
        itest=iinput;     //將資料轉到另一變數使用
        System.out.printf("%d->",iinput);
        int i=0;
        while(itest!=0){    //計算位數
            itest=itest/10;
            i++;
        }
        i-=1;
        itest=iinput;
        while(itest!=0){    //一位一位輸入，反向輸出
            ia+=(itest%10)*Math.pow(10,i);    //將輸入處理相加
            itest=itest/10;
            i--;
        }   
        System.out.printf("%d",ia);
    }
}