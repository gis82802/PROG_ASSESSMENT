/*
filename: app4_3
function: The distance from the point to the line.
author: PoXsun
date: 2024/10/04
version: 11.0.12
*/

import java.util.Scanner;

public class app4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("L: ax + by + c = 0:");
        System.out.println("請輸入以下變數：");
        
        System.out.print("輸入a: ");
        int a = sc.nextInt();
        System.out.print("輸入b: ");
        int b = sc.nextInt();
        System.out.print("輸入c: ");
        int c = sc.nextInt();
        
        System.out.println("請輸入點 P(x0, y0):");
        System.out.print("輸入x0: ");
        int x0 = sc.nextInt();
        System.out.print("輸入y0: ");
        int y0 = sc.nextInt();
        
        // 計算點到直線的距離
        double distance = Math.abs(a * x0 + b * y0 + c) / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("點與直線的距離為: " + distance);
        
        sc.close(); // 關閉掃描器
    }
}
