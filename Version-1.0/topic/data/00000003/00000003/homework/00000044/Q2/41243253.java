import java.util.Scanner;

public class hw3_b 
{ 
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);

        // 輸入2x2矩陣的內容
        System.out.println("請輸入 2x2 矩陣的內容: ");
        int[][] matrix = new int[2][2];
        for (int i = 0; i < 2; i++) 
	{
            for (int j = 0; j < 2; j++) 
	    {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 計算矩陣的反矩陣
        double[][] inverseMatrix = MatInverse(matrix);
        
        if (inverseMatrix == null) 
	{
            System.out.println("該矩陣沒有反矩陣。行列式為 0。");
        } 
	else 
	{
            System.out.println("矩陣的反矩陣為：");
            for (int i = 0; i < 2; i++) 
	    {
                for (int j = 0; j < 2; j++) 
		{
                    System.out.printf("%.2f ", inverseMatrix[i][j]);
                }
                System.out.println();
            }

            // 驗證：計算原矩陣和反矩陣的乘積
            double[][] identity = MatMultiply(matrix, inverseMatrix);
            System.out.println("原矩陣與反矩陣相乘的結果（應為單位矩陣）：");
            for (int i = 0; i < 2; i++) 
	    {
                for (int j = 0; j < 2; j++) 
		{
                    System.out.printf("%.2f ", identity[i][j]);
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }

    // 計算2x2矩陣的反矩陣
    public static double[][] MatInverse(int[][] matrix) 
    {
        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];
        
        int det = a * d - b * c; // 計算行列式

        if (det == 0) 
	{
            return null; // 行列式為0，沒有反矩陣
        }

        double[][] inverse = new double[2][2];
        inverse[0][0] = d / (double)det;
        inverse[0][1] = -b / (double)det;
        inverse[1][0] = -c / (double)det;
        inverse[1][1] = a / (double)det;
        
        return inverse;
    }

    // 計算矩陣乘積的方法（2x2與2x2矩陣）
    public static double[][] MatMultiply(int[][] matrix, double[][] inverseMatrix) 
    {
        double[][] result = new double[2][2];
        
        for (int i = 0; i < 2; i++) 
	{
            for (int j = 0; j < 2; j++) 
	    {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) 
		{
                    result[i][j] += matrix[i][k] * inverseMatrix[k][j];
                }
            }
        }
        
        return result;
    }
}
