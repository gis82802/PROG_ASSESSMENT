import java.util.Scanner;
public class hw4_a 
{
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        
        // 讓使用者輸入 n
        System.out.print("請輸入矩陣的大小 n (n <= 4): ");
        int n = scanner.nextInt();
        
        if (n > 4 || n <= 0) 
	{
            System.out.println("n 必須在 1 到 4 之間");
        }

        // 宣告 n x n 的矩陣
        int[][] matrix = new int[n][n];
        
        // 讓使用者輸入矩陣內容
        System.out.println("請輸入矩陣的內容：");
        for (int i = 0; i < n; i++) 
	{
            for (int j = 0; j < n; j++) 
	    {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextInt();  // 讀取每個內容
            }
        }

        // 輸出矩陣裡的內容
        System.out.println("你輸入的矩陣內容是：");
        for (int i = 0; i < n; i++) 
	{
            for (int j = 0; j < n; j++) 
	    {
                System.out.print(matrix[i][j] + "\t");  // 跳格，內容之間用 \t 分開
            }
            System.out.println();  // 換行
        }
    }
}
