import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

// MyPoint 類別，實現 Comparable 介面
class MyPoint implements Comparable<MyPoint> {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // 實作 compareTo 方法以定義排序規則
    @Override
    public int compareTo(MyPoint other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y);
        }
    }
}

// 包含排序和印出方法的類別
class SortPtArr {
    public static void printArray(MyPoint[] arr) {
        for (MyPoint pt : arr) {
            System.out.print(pt + " ");
        }
        System.out.println();
    }

    public static MyPoint[] sort(MyPoint[] arr) {
        // 使用 Arrays.sort() 進行排序，它會利用 MyPoint 的 compareTo 方法
        Arrays.sort(arr);
        return arr;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入隨機種子碼：");
        long seed = scanner.nextLong();
        scanner.close();

        MyPoint[] ptarr = new MyPoint[10];
        Random random = new Random(seed);

        // 產生 10 個隨機點並存入陣列
        for (int i = 0; i < ptarr.length; i++) {
            int x = random.nextInt(21) - 10; // -10 到 10
            int y = random.nextInt(21) - 10; // -10 到 10
            ptarr[i] = new MyPoint(x, y);
        }

        System.out.println("未排序的隨機點: ");
        SortPtArr.printArray(ptarr);

        MyPoint[] spa = SortPtArr.sort(ptarr);

        System.out.println("已排序的隨機點: ");
        SortPtArr.printArray(spa);
    }
}