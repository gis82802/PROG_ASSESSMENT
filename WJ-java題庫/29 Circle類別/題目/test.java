import java.util.Scanner;

// Circle 類別
class Circle {
    private int x;
    private int y;
    private int radius;

    // 建構子
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // 改變圓心位置的方法
    public void changeCenter(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    // 印出圓形資訊的方法
    public void printInfo() {
        System.out.println("圓心(" + this.x + ", " + this.y + "), 半徑 " + this.radius);
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 建立圓形物件
        Circle a = new Circle(3, 4, 5);

        // 印出初始資訊
        System.out.print("圓形 a 的初始資訊：");
        a.printInfo();

        // 讓使用者輸入新座標
        System.out.println("請輸入圓心的新 x, y 座標 (以空格分隔): ");
        int newX = scanner.nextInt();
        int newY = scanner.nextInt();
        scanner.close();

        // 改變圓心位置
        a.changeCenter(newX, newY);

        // 印出改變後的資訊
        System.out.print("圓形 a 改變後的資訊：");
        a.printInfo();
    }
}