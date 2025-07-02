import java.util.Scanner;
public class hw8 {
    public static void main(String args[]) {
        int i = 100000;
        int num, count = 0;

        for (num = 1; num <= i; num++) {
            int temp = num, prev = 10;
            boolean od = true;

            while (temp > 0) {
                int curr = temp % 10; // 取低位
                temp /= 10; // 刪低位

                if (curr >= prev) { // 若當前數字大於等於上一個數字，則非有序數
                    od = false;
                    break;
                }
                prev = curr; // 更新上一個數字為當前數字
            }

            if (od) {
                count++;
            }
        }
        System.out.println(i + "以內有" + count + "個有序數");
    }
}
