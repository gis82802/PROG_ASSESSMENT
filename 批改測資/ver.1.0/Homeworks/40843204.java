/*
40843204 ���P���A��J
*/
import java.util.Scanner; 
public class app10_5{
	public static void main(String args[]){
		Scanner san=new Scanner(System.in);
		byte b;
		short s;
		int i;
		char c;
		long l;
		float f;
		double d;
		//System.out.print("��JByte= ");
		b=san.nextByte();
		//System.out.print("��JShort= ");
		s=san.nextShort();
		//System.out.print("��Jint= ");
		i=san.nextInt();
		//System.out.print("��Jchar= ");
		c=san.next().charAt(0);
		//System.out.print("��Jlong= ");
		l=san.nextLong();
		//System.out.print("��Jfloat= ");
		f=san.nextFloat();
		//System.out.print("��Jdouble= ");
		d=san.nextDouble();
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(c);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
        //System.out.println("��X Byte :"+b+"  ��X short :"+s+"  ��X int :"+i+"\n"+"��X char :"+c+"  ��X long :"+l+"  ��X float :"+f+"  ��X double :"+d);
	}
} 