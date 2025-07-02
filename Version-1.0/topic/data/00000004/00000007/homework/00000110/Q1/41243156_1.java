import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;
public class hwa{
    
    public static void main(String[] args ){//第一題的A部分
    Scanner s = new Scanner(System.in);
    System.out.println("輸入你的陣列內容");
    int[] str = new int[10];
    int temp;
   for(int i=0;i<10;i++){
        str[i]=s.nextInt();
   }
    System.out.println("排序前的陣列內容："+Arrays.toString(str));
    for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) { // 修正迴圈條件
                if (str[i] < str[j]) { // 這裡從大到小排序
                    temp = str[j];
                    str[j] = str[i];
                    str[i] = temp;
                }
            }
        }

    
    System.out.println("排序後的陣列內容："+Arrays.toString(str));
    }
}