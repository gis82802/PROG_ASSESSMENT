import java.util.Scanner;
public class hw6{
	public static void main(String args[]){

		for(int num=1;num<=10;num++){

			int max=num*10000;
			double pi=1;
			double i;
			for(i=2;i<=max;i++){
				if((i%2)==0)
					pi-=(1/(2*i-1));
				else
					pi+=(1/(2*i+1));
			}
			System.out.println("i="+max+",pi="+(pi*4));
	
		}
	}
}
