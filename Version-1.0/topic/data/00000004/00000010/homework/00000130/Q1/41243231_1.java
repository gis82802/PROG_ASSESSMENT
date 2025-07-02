/*
    Filename: "hw03.java"
    Function: 矩陣相乘、反矩陣
    Author: SHUN-YE XU
    Version: 23.0.1
    date: 2024/10/25
*/

import java.util.Scanner;
public class hw03
{
    public static void main(String args[])
    {
        float[][] a, b;
        int n, m;
        Scanner sc = new Scanner(System.in);
        
        // 輸入矩陣a
        System.out.print("輸入矩陣a的n, m:");
        n = sc.nextInt(); m = sc.nextInt();
        a = new float[n][m];
        System.out.println("輸入矩陣a的內容:");
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        // 輸入矩陣b
        System.out.print("輸入矩陣b的n, m:");
        n = sc.nextInt(); m = sc.nextInt();
        b = new float[n][m];
        System.out.println("輸入矩陣a的內容:");
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                b[i][j] = sc.nextInt();
        sc.close();

        // axb
        float[][] r = matMultiply(a,b);
        System.out.println("a x b=");
        if(r == null) System.out.print("無法相乘");
        else print_mat(r);

        // a的反矩陣和驗證
        float[][] ia, re;
        ia = invMatrix(a);
        System.out.println("\nInverse Matrix a=");
        print_mat(ia);
        re = matMultiply(ia, a);
        System.out.println("\nInverse Matrix a x Matrix a=");
        print_mat(re);
    }

    public static float[][] matMultiply(float[][] a, float[][] b)
    {
        if(a[0].length != b.length) return null;

        float[][] result;
        result = new float[a.length][b[0].length];
        
        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < b[0].length; j++)
                result[i][j] = 0;

        int sum;
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < b[0].length; j++)
            {
                sum = 0;
                for(int z = 0; z < a[0].length; z++)
                {
                    sum += a[i][z] * b[z][j];
                }

                result[i][j] = sum;
            }
        }

        return result;
    }

    public static float[][] invMatrix(float[][] a)
    {
        float[][] invMat = new float[2][2];
        float det = a[0][0] * a[1][1] - a[0][1] * a[1][0];
        
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                int s = 1;
                if(i != j) s = -1;
                invMat[1-j][1-i] = a[i][j] * (s/det);
            }
        }

        return invMat;
    }

    public static void print_mat(float[][] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}