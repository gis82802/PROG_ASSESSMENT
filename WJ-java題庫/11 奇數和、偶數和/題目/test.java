import java.util.Scanner;

// 計算奇數總和的執行緒
class OddSumThread extends Thread {
    private int n;
    private long oddSum;

    public OddSumThread(int n) {
        this.n = n;
        this.oddSum = 0;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i += 2) {
            oddSum += i;
        }
    }

    public long getOddSum() {
        return oddSum;
    }
}

// 計算偶數總和的執行緒
class EvenSumThread extends Thread {
    private int n;
    private long evenSum;

    public EvenSumThread(int n) {
        this.n = n;
        this.evenSum = 0;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; i += 2) {
            evenSum += i;
        }
    }

    public long getEvenSum() {
        return evenSum;
    }
}

public class test {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一個正整數N: ");
        int n = scanner.nextInt();
        scanner.close();

        // 創建兩個執行緒
        OddSumThread oddThread = new OddSumThread(n);
        EvenSumThread evenThread = new EvenSumThread(n);

        // 啟動執行緒
        oddThread.start();
        evenThread.start();

        // 等待兩個執行緒完成計算
        oddThread.join();
        evenThread.join();

        // 獲取並相加結果
        long oddSum = oddThread.getOddSum();
        long evenSum = evenThread.getEvenSum();
        long totalSum = oddSum + evenSum;

        // 直接計算總和以進行驗證
        long directSum = (long) n * (n + 1) / 2;

        System.out.println("奇數總和: " + oddSum);
        System.out.println("偶數總和: " + evenSum);
        System.out.println("總和: " + totalSum);
        System.out.println("驗證: 1到" + n + "的總和為" + directSum);
    }
}