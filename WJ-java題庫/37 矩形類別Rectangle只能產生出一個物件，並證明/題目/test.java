class Rectangle {
    // 唯一的實例
    private static Rectangle instance;

    // 參數，可根據需要添加
    private int x, y, width, height;

    // 私有建構子，防止外部直接實例化
    private Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // 公有靜態方法，用於獲取唯一的實例
    public static Rectangle getInstance(int x, int y, int width, int height) {
        if (instance == null) {
            // 第一次呼叫時才建立實例
            instance = new Rectangle(x, y, width, height);
        }
        return instance;
    }
}

public class test {
    public static void main(String[] args) {
        // 嘗試建立兩個物件
        Rectangle rect1 = Rectangle.getInstance(0, 0, 10, 5);
        Rectangle rect2 = Rectangle.getInstance(20, 20, 8, 8); // 這些參數會被忽略

        // 判斷兩個參考變數是否指向同一個物件
        if (rect1 == rect2) {
            System.out.println("成功：兩個物件指向同一個實例。");
        } else {
            System.out.println("失敗：建立了多個實例。");
        }
    }
}