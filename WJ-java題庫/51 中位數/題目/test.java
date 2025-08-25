import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        //System.out.println("輸入一個數字，以 -1 結束:");

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("輸入格式不正確，請輸入整數。");
                scanner.next(); // 消耗錯誤輸入
                continue;
            }

            int num = scanner.nextInt();
            if (num == -1) {
                break;
            }

            numbers.add(num);
            
            // 每次新增數字後，都重新排序並計算中位數
            Collections.sort(numbers);

            double median;
            int size = numbers.size();

            if (size % 2 == 1) {
                // 奇數個數字
                median = numbers.get(size / 2);
            } else {
                // 偶數個數字
                int middle1 = numbers.get(size / 2 - 1);
                int middle2 = numbers.get(size / 2);
                median = (double) (middle1 + middle2) / 2.0;
            }

            System.out.println("中位數: " + median);
            //System.out.println("輸入一個數字，以 -1 結束:");
        }

        scanner.close();
        System.out.println("程式結束。");
    }
}