import java.util.Scanner;
public class hw2{
    public static void main(String[] args){
        int icount=0,iinput,itest,ikey=0;
        Scanner scn=new Scanner(System.in);
        System.out.print("請輸入一串數字:");
        iinput=scn.nextInt();
        itest=iinput;    //將資料轉到另一變數使用
        int ia,ib;       //ia為前項，ib為後項
        ia=itest%10;     //取個位數
        itest=itest/10;  //整體除十，移除個位數
        while(itest!=0){    //ia、ib比較
            ib=itest%10;
            itest=itest/10;
            if(ia<=ib) ikey=1;
            ia=ib;
        }
        if(ikey==1)
            System.out.printf("%d is not a well-ordered number\n",iinput);
        else
            System.out.printf("%d is a well-ordered number\n",iinput);
        int count=0;
        for(int i=1;i<=100000;i++){
        ikey=0;
        itest=i;    //將資料轉到另一變數使用
        ia=itest%10;    //ia為前項，ib為後項
        itest=itest/10;    //取個位數
        while(itest!=0){    //ia、ib比較
            ib=itest%10;
            itest=itest/10;
            if(ia<=ib) ikey=1;
            ia=ib;
        }
        if(ikey==0)
            count++;

        }
        System.out.printf("1~100000 have %d well-ordered number",count);
    }
}