import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class test {

    private static int playerAMove = -1;
    private static int playerBMove = -1;
    private static int scoreA = 0;
    private static int scoreB = 0;
    private static final int TOTAL_ROUNDS = 5;

    // 使用 Semaphore 來同步選手與裁判
    private static Semaphore playerReady = new Semaphore(0);
    private static Semaphore refereeReady = new Semaphore(0);

    // 判斷勝負
    private static int determineWinner(int moveA, int moveB) {
        if (moveA == moveB) return 0; // 平手
        if ((moveA == 0 && moveB == 2) || (moveA == 1 && moveB == 0) || (moveA == 2 && moveB == 1)) {
            return 1; // 選手A獲勝
        }
        return 2; // 選手B獲勝
    }

    // 數字轉文字
    private static String getMoveName(int move) {
        return switch (move) {
            case 0 -> "剪刀";
            case 1 -> "石頭";
            case 2 -> "布";
            default -> "未知";
        };
    }

    static class PlayerA extends Thread {
        private Random random;

        public PlayerA(long seed) {
            this.random = new Random(seed);
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < TOTAL_ROUNDS; i++) {
                    refereeReady.acquire(); // 等待裁判準備好
                    playerAMove = random.nextInt(3);
                    playerReady.release(); // 通知裁判我準備好了
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class PlayerB extends Thread {
        private Random random;

        public PlayerB(long seed) {
            this.random = new Random(seed);
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < TOTAL_ROUNDS; i++) {
                    refereeReady.acquire(); // 等待裁判準備好
                    playerBMove = random.nextInt(3);
                    playerReady.release(); // 通知裁判我準備好了
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Referee extends Thread {
        @Override
        public void run() {
            try {
                for (int round = 1; round <= TOTAL_ROUNDS; round++) {
                    System.out.println("裁判: 第 " + round + " 輪比賽開始！");
                    refereeReady.release(2); // 允許兩個選手出拳
                    
                    playerReady.acquire(2); // 等待兩位選手都出拳
                    
                    System.out.println("選手A 出拳: " + getMoveName(playerAMove));
                    System.out.println("選手B 出拳: " + getMoveName(playerBMove));
                    
                    int winner = determineWinner(playerAMove, playerBMove);
                    if (winner == 1) {
                        scoreA++;
                        System.out.println("裁判: 第 " + round + " 輪結果 -> 選手A 獲勝！");
                    } else if (winner == 2) {
                        scoreB++;
                        System.out.println("裁判: 第 " + round + " 輪結果 -> 選手B 獲勝！");
                    } else {
                        System.out.println("裁判: 第 " + round + " 輪結果 -> 平手！");
                    }
                    System.out.println("選手A 獲勝 " + scoreA + " 次, 選手B 獲勝 " + scoreB + " 次\n");
                    
                    if (scoreA >= 3 || scoreB >= 3) {
                        break;
                    }
                }
                
                System.out.println("裁判: 5 輪比賽結束，最終結果：");
                System.out.println("選手A 獲勝 " + scoreA + " 次");
                System.out.println("選手B 獲勝 " + scoreB + " 次");

                if (scoreA > scoreB) {
                    System.out.println("最終獲勝者是：選手A！");
                } else if (scoreB > scoreA) {
                    System.out.println("最終獲勝者是：選手B！");
                } else {
                    System.out.println("比賽平手。");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入隨機種子碼: ");
        long seed = scanner.nextLong();
        scanner.close();

        PlayerA playerA = new PlayerA(seed);
        PlayerB playerB = new PlayerB(seed + 1);
        Referee referee = new Referee();

        playerA.start();
        playerB.start();
        referee.start();

        // 等待所有執行緒結束
        playerA.join();
        playerB.join();
        referee.join();
    }
}