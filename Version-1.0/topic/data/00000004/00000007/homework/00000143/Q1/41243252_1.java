import java.util.Scanner;

public class ch6_1 {
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

            System.out.print("排序前的陣列內容: ");
            for (int a = 0; a < number; a++) {
                System.out.print(arry[a] + (a < number - 1 ? "," : ""));
            }
            System.out.println();


            Sort(arry);

            // 輸出排序後的陣列內容
            System.out.print("排序後的陣列內容: ");
            for (int a = 0; a < number; a++) {
                System.out.print(arry[a] + (a < number - 1 ? "," : ""));
            }
            System.out.println(); 
        } 

        scanner.close(); 
    }

    // 插入排序
    public static void Sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; 
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; 
                j--;
            }
            array[j + 1] = key; 
        }
    }
}
