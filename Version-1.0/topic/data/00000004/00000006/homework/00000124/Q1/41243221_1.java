public class hw1{
    public static void main(String[] args){
        double d_sum=1;    //公式:開頭1
        double d_PI=0;     //數值PI
        float count=2;     //計數器
        for(int i=1;i<=10;i++){    //計算次數
            d_sum=1;
            for(float j=2;j<=i*10000;j+=2){    //計算PI值
                d_sum+=-1/(2*j-1)+1/(2*j+1);    //公式:後段
            }
            d_PI=4*d_sum;    //公式:乘4
            System.out.printf("i=%6d:%f\n",i*10000,d_PI);
        }
        System.out.println("-------------------------------");
        d_sum=1;    //公式:開頭1
        do{    //計算PI值
            d_sum+=-1/(2*count-1)+1/(2*count+1);    //公式:後段
            d_PI=4*d_sum;    //公式:乘4
            count+=2;
        }while(Math.abs(d_PI-3.14159)>0.00001);    //結束條件
        System.out.println("When i="+count+",PI is 3.14159");
    }
}