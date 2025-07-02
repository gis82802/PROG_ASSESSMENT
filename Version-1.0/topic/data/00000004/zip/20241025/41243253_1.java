import java.util.Scanner;

public class hw3_a 
{ 
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);

        // 輸入第一個矩陣的大小
        System.out.print("請輸入第一個矩陣的大小（行 列）: ");
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int arr[][] = new int[i][j];
        
        // 輸入第一個矩陣的內容
        System.out.println("請輸入第一個矩陣的內容: ");
        for (int row = 0; row < i; row++) 
	{
            for (int col = 0; col < j; col++) 
	    {
                arr[row][col] = scanner.nextInt();
            }
        }

        // 輸入第二個矩陣的大小
        System.out.print("請輸入第二個矩陣的大小（行 列）: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int arr1[][] = new int[x][y];
        
        // 輸入第二個矩陣的內容
        System.out.println("請輸入第二個矩陣的內容: ");
        for (int row = 0; row < x; row++) 
	{
            for (int col = 0; col < y; col++) 
	    {
                arr1[row][col] = scanner.nextInt();
            }
        }

        // 呼叫矩陣相乘方法
        int[][] result = MatMultiply(arr, arr1);
        
        // 顯示結果矩陣
        if (result != null) 
	{
            System.out.println("矩陣相乘的結果為：");
            for (int row = 0; row < result.length; row++) 
	    {
                for (int col = 0; col < result[0].length; col++) 
		{
                    System.out.print(result[row][col] + " ");
                }
                System.out.println();
            }
        } 
	else 
	{
            System.out.println("無法進行矩陣相乘，請確保第一個矩陣的列數等於第二個矩陣的行數。");
        }
        
        scanner.close();
    }
    
    public static int[][] MatMultiply(int arr[][], int arr1[][]) 
    {
        // 檢查矩陣相乘的條件
        if (arr[0].length != arr1.length) 
	{
            return null;
        }

        // 初始化結果矩陣
        int result[][] = new int[arr.length][arr1[0].length];
        
        // 執行矩陣相乘
        for (int i = 0; i < arr.length; i++) 
	{
            for (int j = 0; j < arr1[0].length; j++) 
	    {
                result[i][j] = 0; // 初始化結果矩陣元素
                for (int k = 0; k < arr[0].length; k++) 
		{
                    result[i][j] += arr[i][k] * arr1[k][j];
                }
            }
        }
        
        return result; // 回傳結果矩陣
    }
}
