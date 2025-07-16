/*
filename:dataInput
function:Input data
author:³¯ÙÉ·Ô
date:2020/10/05
version:1.0
*/
import java.util.Scanner;
public class dataInput{
	public static void main(String arg[]){
		Scanner scan = new Scanner(System.in);
		//System.out.println("Input data (Byte):");
		System.out.println(scan.nextByte());
		//System.out.println("Input data (short):");
		System.out.println(scan.nextShort());
		//System.out.println("Input data (int):");
		System.out.println(scan.nextInt());
		//System.out.println("Input data (char):");
		System.out.println(scan.next().charAt(0));
		//System.out.println("Input data (long):");
		System.out.println(scan.nextLong());
		//System.out.println("Input data (float):");
		System.out.println(scan.nextFloat());
		//System.out.println("Input data (double):");
		System.out.println(scan.nextDouble());
	}
}