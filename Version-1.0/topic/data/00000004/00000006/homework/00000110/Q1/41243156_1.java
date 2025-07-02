import java.lang.Math;
public class hwa{
    public static void soultion(long n){//第一題的A部分
    double pi=0;
    for(long i=1;i<=n;i++){
       if(i%2!=0){
        pi+=(double)1/((double)2*i-1);
       }
       else{
        pi-=(double)1/((double)2*i-1);
       }
    }
    pi=pi*4;
    System.out.println("答案："+pi);
    }
    public static void soultion1(){//第一題的B部分
        double pi=3.14159;
        double temp=0;
        long i=1;
        while(true){
            if(i%2!=0){
                temp+=(double)1/((double)2*i-1);
            }
            else{
                temp-=(double)1/((double)2*i-1);
            }
            i++;
            if(Math.abs(4*temp-pi)<0.000001){
                break;
            }
        }
        System.out.println(i-1);
    }
    public static void main(String avgs[]){
       
       for(long i=10000;i<=100000;i+=10000){
            soultion(i);
       }
       System.out.print("b部分：");
       soultion1();
    }
}