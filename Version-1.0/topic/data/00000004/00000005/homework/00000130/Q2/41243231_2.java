/*
    Filename: "App02_1004"
    Function: �D�I�쪽�u�Z��
    Author: SHUN-YE XU
    Version: 17.0.11
    date: 2024/10/4
*/

import java.util.Scanner;

public class App02_1004
{
    
    public static void main(String[] args)
    {
	float x, y, m, cept;
	double distance;

	Scanner s = new Scanner(System.in);

	System.out.print("��Jx,y: ");
	x = s.nextFloat(); y = s.nextFloat();
	System.out.print("��J�ײv,�I�Z: ");
	m = s.nextFloat(); cept = s.nextFloat();
	
	distance = Math.abs(m*x - y + cept) / Math.sqrt(m*m + 1); 
	System.out.println("�I�쪽�u�Z��" + distance);
    }
}	