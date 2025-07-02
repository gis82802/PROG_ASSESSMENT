/*
filename:app 7_1
funtion:mult matrix
auther:ToBoShu
date:2024/10/25e
version:jdk23
*/
/*
System.out.println();
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
throws Exxception
Thread.sleep(x);
Math.pow(x,2.0);
Math.squt(x);
*/


import java.util.Scanner;

public class app7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("請輸入第一個矩陣的大小(row col): ");
        int arow = sc.nextInt();
        int acol = sc.nextInt();
        
        System.out.print("請輸入第二個矩陣的大小(row col): ");
        int brow = sc.nextInt();
        int bcol = sc.nextInt();

        if(acol != brow) {
            System.out.println("NULL");
            return;
        }

        System.out.println("請輸入第一個矩陣的內容:");
        int[][] aMatrix = new int[arow][acol];
        for(int i = 0; i < arow; i++) {
            for(int j = 0; j < acol; j++) {
                aMatrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("請輸入第二個矩陣的內容:");
        int[][] bMatrix = new int[brow][bcol];
        for(int i = 0; i < brow; i++) {
            for(int j = 0; j < bcol; j++) {
                bMatrix[i][j] = sc.nextInt();
            }
        }

        int[][] resultMatrix = multiplyMatrices(aMatrix, bMatrix, arow, acol, bcol);

        System.out.println("相乘後的矩陣結果為:");
        for(int i = 0; i < arow; i++) {
            for(int j = 0; j < bcol; j++) {
                System.out.printf("%5d ", resultMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b, int arow, int acol, int bcol) {
        int[][] result = new int[arow][bcol];
        for(int i = 0; i < arow; i++) {
            for(int j = 0; j < bcol; j++) {
                for(int k = 0; k < acol; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}

