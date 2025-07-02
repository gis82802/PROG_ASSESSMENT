// File name: app5_2
// Author: 41243142
// Function: 
// Date: 24/10/11
// Version:

import java.util.Scanner;

public class app5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("�п�J�@�Ӿ��: ");
        int number = scanner.nextInt();

        if (isWO(number)) {
            System.out.println(number + " �O�@�ӻ��W�ơC");
        } else {
            System.out.println(number + " ���O�@�ӻ��W�ơC");
        }

        int w = cNumbers(1, 100000);
        System.out.println("1��100000���������W�ƭӼƬ�: " + w);
        
        scanner.close();
    }

    public static boolean isWO(int number) {
        int a= 10;
        while (number > 0) {
            int cc = number % 10;
            if (cc >= a){
                return false;
            }
           a = cc;
            number /= 10;
        }
        return true;
    }

    public static int cNumbers(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isWO(i)) {
                count++;
            }
        }
        return count;
    }
}
