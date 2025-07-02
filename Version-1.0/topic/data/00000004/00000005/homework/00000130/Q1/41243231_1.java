/*
    Filename: "App01_1004"
    Function: �D���u��{���B�ڦ��Z���B�ҫ��y�Z���B���񳷤ҶZ���B����
    Author: SHUN-YE XU
    Version: 11.0.12
    date: 2024/10/4
*/

import java.util.Scanner;

public class App01_1004
{
    
    public static void main(String[] args)
    {
	int x1, x2, y1, y2, m, b;
	double angle;
	Scanner s = new Scanner(System.in);

	System.out.print("��Jx1,y1: ");
	x1 = s.nextInt(); y1 = s.nextInt();
	System.out.print("��Jx2,y2: ");
	x2 = s.nextInt(); y2 = s.nextInt();
	
	m = (y2-y1) / (x2-x1); // �D�ײv
	b = y1 - m * x1;
	angle = Math.toDegrees(Math.acos((x1*x2+y1*y2) / (Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2))));
	
	if(b < 0)
	{
	    System.out.println("���u��{��: y = "+m+"x - "+Math.abs(b)+"");
	}
	    
	else
	{
	    System.out.println("���u��{��: y = "+m+"x + "+b+"");
	}
	    
	System.out.println("�ڦ��Z��: "+ Math.sqrt(Math.pow(x1-y1, 2) + Math.pow(x2-y2, 2)));
	System.out.println("�ҫ��y�Z��: "+ Math.abs(x1-x2) + Math.abs(y1-y2));
	System.out.println("���񳷤ҶZ��: "+ Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
	System.out.println("����: "+ angle/180 * Math.PI);
	
    }
}