public class test {

    public static void main(String[] args) {
        // 建立一個 101 個元素的布林陣列，索引 0 閒置不用，方便對應儲物櫃編號 1-100
        boolean[] lockers = new boolean[101]; // false 表示關閉

        // 模擬 100 名學生
        for (int student = 1; student <= 100; student++) {
            // 學生從自己的編號開始，改變每個 student 倍數的儲物櫃狀態
            for (int locker = student; locker <= 100; locker += student) {
                lockers[locker] = !lockers[locker];
            }
        }

        // 印出最終狀態
        for (int i = 1; i <= 100; i++) {
            if (lockers[i]) {
                System.out.print("O ");
            } else {
                System.out.print("C ");
            }
            
            // 每 10 個儲物櫃換行
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}