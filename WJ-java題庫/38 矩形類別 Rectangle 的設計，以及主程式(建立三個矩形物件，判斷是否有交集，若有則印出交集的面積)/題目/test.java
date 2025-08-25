import java.util.Scanner;

class Rectangle {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // 取得交集面積
    public int getIntersectionArea(Rectangle other) {
        // 計算交集矩形的座標
        int intersectionX = Math.max(this.x, other.x);
        int intersectionY = Math.max(this.y, other.y);
        
        // 計算交集矩形的寬度和高度
        int intersectionWidth = Math.min(this.x + this.width, other.x + other.width) - intersectionX;
        int intersectionHeight = Math.min(this.y + this.height, other.y + other.height) - intersectionY;

        // 如果寬度或高度小於等於0，表示沒有交集
        if (intersectionWidth <= 0 || intersectionHeight <= 0) {
            return 0;
        }

        return intersectionWidth * intersectionHeight;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("請輸入 rect1 的 x, y, width, height (以空格分隔):");
        Rectangle rect1 = new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        
        //System.out.println("請輸入 rect2 的 x, y, width, height (以空格分隔):");
        Rectangle rect2 = new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        
        //System.out.println("請輸入 rect3 的 x, y, width, height (以空格分隔):");
        Rectangle rect3 = new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        
        scanner.close();
        
        // 判斷 rect1 和 rect2
        int area12 = rect1.getIntersectionArea(rect2);
        if (area12 > 0) {
            System.out.println("rect1 與 rect2 的交集面積：" + area12);
        } else {
            System.out.println("rect1 與 rect2 沒有交集。");
        }

        // 判斷 rect1 和 rect3
        int area13 = rect1.getIntersectionArea(rect3);
        if (area13 > 0) {
            System.out.println("rect1 與 rect3 的交集面積：" + area13);
        } else {
            System.out.println("rect1 與 rect3 沒有交集。");
        }
        
        // 判斷 rect2 和 rect3
        int area23 = rect2.getIntersectionArea(rect3);
        if (area23 > 0) {
            System.out.println("rect2 與 rect3 的交集面積：" + area23);
        } else {
            System.out.println("rect2 與 rect3 沒有交集。");
        }
    }
}