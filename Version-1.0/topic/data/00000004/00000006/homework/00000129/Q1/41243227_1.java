public class hw1_1
{
      public static void main(String arg[]){
	double i,j,PI;
	j=1;
	i=0;
	do{
		i+=2;
		j=j-1/(2*i-1)+1/(2*i+1);
		PI=4*j;
			System.out.println(PI);	
			}while(PI>3.1416);              //當小於3.1416的第1個數字就會是3.14159
	System.out.println("i="+i);		
	}
}