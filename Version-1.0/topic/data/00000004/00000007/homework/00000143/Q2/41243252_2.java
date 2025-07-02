import java.util.Scanner;

public class ch6_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0; 
        int[] arry = null;

        while (true) {
            System.out.print("輸入陣列大小: ");
            number = scanner.nextInt();

            if (number == 0) {
                System.out.println("跳出程式");
                break;
            }

            // 初始化陣列大小
            arry = new int[number];

            System.out.println("輸入數值:");
            for (int a = 0; a < number; a++) {
                arry[a] = scanner.nextInt();
            }

            System.out.print("陣列內容: ");
            for (int a = 0; a < number; a++) {
                System.out.print(arry[a] + (a < number - 1 ? "," : ""));
            }
            System.out.println();

            // 計算並輸出最大值和最小值陣列
            int[] maxArray = max(arry);
            int[] minArray = min(arry);

            System.out.print("max\n[");
            for (int i = 0; i < maxArray.length; i++) {
                System.out.print(maxArray[i]);
                if (i < maxArray.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            System.out.print("min\n[");
            for (int i = 0; i < minArray.length; i++) {
                System.out.print(minArray[i]);
                if (i < minArray.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } 

        scanner.close(); 
    }

    // 計算右側最大值
    public static int[] max(int[] array) {
        int n = array.length;
        int[] maxArray = new int[n];
        maxArray[n - 1] = -1; // 最後一個元素右邊沒有元素，所以設為 -1

        for (int i = n - 2; i >= 0; i--) {
            // 手動比較找到最大值
            int rightMax = array[i + 1]; // 初始化右側最大值為下一個元素
            for (int j = i + 1; j < n; j++) {
                if (array[j] > rightMax) {
                    rightMax = array[j];
                }
            }
            maxArray[i] = rightMax;
        }

        return maxArray;
    }

    // 計算右側最小值
    public static int[] min(int[] array) {
        int n = array.length;
        int[] minArray = new int[n];
        minArray[n - 1] = -1; // 最後一個元素右邊沒有元素，所以設為 -1

        for (int i = n - 2; i >= 0; i--) {
            // 手動比較找到最小值
            int rightMin = array[i + 1]; // 初始化右側最小值為下一個元素
            for (int j = i + 1; j < n; j++) {
                if (array[j] < rightMin) {
                    rightMin = array[j];
                }
            }
            minArray[i] = rightMin;
        }

        return minArray;
    }
}
