// File name: app5_3
// Author: 41243142
// Function: ����ϥΪ̿�J���Ʀr����
// Date: 24/10/11
// Version:

import java.util.Scanner;

public class app5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("�п�J�@�Ӿ��: ");
        int number = scanner.nextInt();

        int rdNumber = rNumber(number); 
        System.out.println("����᪺�Ʀr��: " + rdNumber);  
        
        scanner.close();
    }

    public static int rNumber(int number) {
        int a = 0;
        while (number != 0) {
            int digit = number % 10; 
            a = a * 10 + digit; 
            number /= 10; 
        }
        return a;
    }
}
