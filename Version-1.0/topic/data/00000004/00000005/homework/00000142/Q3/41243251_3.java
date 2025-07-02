import java.util.Scanner;
import java.lang.Math;
public class hw3_1004 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		float max,min,middle;
		float[] Num=new float[3];
		System.out.println("輸入3個數 :");
		for(int i=0;i<3;i++)
			Num[i] = scn.nextFloat();
		max = (Num[0]>Num[1]&&Num[0]>Num[2])?Num[0]:		//找最大值
		      (Num[1]>Num[0]&&Num[1]>Num[2])?Num[1]: Num[2];	
		min = (Num[0]<Num[1]&&Num[0]<Num[2])?Num[0]:		//找最小值
		      (Num[1]<Num[0]&&Num[1]<Num[2])?Num[1]: Num[2];
		middle = (((Num[0]==max)&&(Num[1]==min))||((Num[1]==max)&&(Num[0]==min)))?Num[2]:		//找中間值
			 (((Num[1]==max)&&(Num[2]==min))||((Num[2]==max)&&(Num[1]==min)))?Num[0]:Num[1];
		System.out.println("MAX = "+max);
		System.out.println("MIN = "+min);
		System.out.println("MIDDLE = "+middle);
	}
}