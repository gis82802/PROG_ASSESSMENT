public class HW1_a{
   public static void main (String[] args){
   //double sum=1;
   for (int i=10000;i<=100000;i+=10000){
   double sum=1;
   for(double a=2;a<=i;a+=2){
         sum+=1/(2*a+1);      
         sum-=1/(2*a-1);
      }
       System.out.printf("%.6f\n", 4 * sum);
   }
   }
}