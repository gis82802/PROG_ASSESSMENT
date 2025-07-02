public class Oneab
{
   public static void main (String[] args)
   {	
      double sum=1;
      for (int i=1;i<=100000;i++)
      {  
	 sum+=Math.pow(-1,i)/(2*i+1);
         if (i%10000==0)
         {
	 double Rsum=sum*4;
         System.out.printf("The pi of %d is %.6f\n",i,Rsum);
         }
      }
      sum = 0; 
      int i = 0; 
      double Rsum = 0; 
      do {
            Rsum = sum * 4; 
            sum += Math.pow(-1, i) / (2 * i + 1);
            i++; 
        } while (Math.abs(Rsum - 3.1415926) >= 0.000001); 
        System.out.printf("The i of 3.14159 is %d%n", i);
   }
}