public class welln {
    public static void main(String[] args) {
        int t = 0;
        for (int num = 0; num <= 100000; num++) {
            int a = num;
            while (a != 0) {
                int mm1 = a % 10;
                int mm2 = (a % 100) / 10;
                if (mm1 <= mm2) {
                    break;//非well-ordered numbers會跳出
                }
                a /= 10;
            }
            if (a==0) {//中途沒有跳出所以代表該數字是well-ordered numbers
                t++;//計數器++
            }
        }
        System.out.print(" 0 到 100000 之間的 well-ordered numbers 有 "+t+" 個");
    }
}
