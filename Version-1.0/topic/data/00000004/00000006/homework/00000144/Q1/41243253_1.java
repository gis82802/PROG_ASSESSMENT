public class hw1_1 
{ 
    public static void main(String[] args) 
    {
   
        for (int j = 10000; j <= 100000; j += 10000) 
        {
            double PI = 0;  // 初始PI值

            for (int i = 1; i <= j; i += 2) 
            {
                if ((i / 2) % 2 == 0) 
                {
                    PI += 1.0 / i;  // 偶數項加
                } 
                else 
                {
                    PI -= 1.0 / i;  // 奇數項減
                }
            }

            PI = 4 * PI;  // 乘4來得到PI

            
            System.out.printf("當 j=%d, pi 值為 %.15f\n", j, PI);// 使用 printf 輸出，顯示保留 15 位小數的 PI 值
        }
    }
}
