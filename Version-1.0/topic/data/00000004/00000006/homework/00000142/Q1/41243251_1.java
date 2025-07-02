import java.util.Scanner;

public class hw1_1011 {
    public static void main(String[] args){
        double pi=0, num,x;
        for (double i = 10000; i <= 100000; i += 10000) {
            num = 0;
            for (double j = 1; j <= i; j++) {
		if((j%2)==1){
		  num=num+(1/(2*j-1));
		} 
		else{
		  num=num-(1/(2*j-1));
		}              
            }
            pi = 4 * num;
            System.out.println(i + " 的pi = " + pi);
        }
	x=10000;
	while(true){
              num = 0;
              for (double j = 1; j <= x; j++) {
		  if((j%2)!=0){
		     num=num+(1/(2*j-1));
		  } 
		  else{
    	             num=num-(1/(2*j-1));
	          }              
              }
	      pi = 4 * num;
	      if(pi>=3.14159){
		break;
	      }
	      x+=2;
         }
	 System.out.println("i值最小為 : "+x);
    }
}
