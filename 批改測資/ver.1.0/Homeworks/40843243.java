/*
�Ǹ�:40843243
�m�W:���F�w
�@�~:�g�{�����ϥΪ̿�J���P��l��ƫ��A�����
���:10/5
*/
import java.util.Scanner;
public class  app3_13
{
   public static void main (String args[])
   {
	Scanner scn=new Scanner(System.in);
 	int i;
	double d;
	short s;
	byte b;
	long l;
	float f;
	String ch;	
	//System.out.println("�п�Jbyte:");
	b=scn.nextByte();
	System.out.println(b);
	//System.out.println("�п�Jshort:");
	s=scn.nextShort();
	System.out.println(s);
	//System.out.println("�п�Jint:");
	i=scn.nextInt();
	System.out.println(i);
	//System.out.println("�п�Jchar:");
	ch=scn.next();
	System.out.println(ch.charAt(0));
	//System.out.println("�п�Jlong:");
	l=scn.nextLong();
	System.out.println(l);
	//System.out.println("�п�Jfloat:");
	f=scn.nextFloat();
	System.out.println(f);
	//System.out.println("�п�Jdouble:");
     	d=scn.nextDouble();
	System.out.println(d);			
   }			

}