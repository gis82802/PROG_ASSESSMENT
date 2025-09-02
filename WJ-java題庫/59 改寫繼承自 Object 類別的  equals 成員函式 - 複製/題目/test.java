import java.util.Scanner;

class Cylinder {
    private int centerX;
    private int centerY;
    private int radius;
    private int height;

    public Cylinder(int centerX, int centerY, int radius, int height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. 檢查是否為同一個物件實例
        if (this == obj) {
            return true;
        }
        // 2. 檢查傳入物件是否為 null 或型別不符
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        // 3. 轉型並比較屬性
        Cylinder other = (Cylinder) obj;
        return this.centerX == other.centerX &&
               this.centerY == other.centerY &&
               this.radius == other.radius &&
               this.height == other.height;
    }

    @Override
    public String toString() {
        return "(圓心: (" + centerX + ", " + centerY + "), 半徑: " + radius + ", 高度: " + height + ")";
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //System.out.println("請輸入第一個圓柱體 c1 的屬性 (圓心x, 圓心y, 半徑, 高度)：");
        Cylinder c1 = new Cylinder(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        
        //System.out.println("請輸入第二個圓柱體 c2 的屬性 (圓心x, 圓心y, 半徑, 高度)：");
        Cylinder c2 = new Cylinder(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        
        //System.out.println("請輸入第三個圓柱體 c3 的屬性 (圓心x, 圓心y, 半徑, 高度)：");
        Cylinder c3 = new Cylinder(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        scanner.close();
        
        //System.out.println("c1: " + c1);
        //System.out.println("c2: " + c2);
        //System.out.println("c3: " + c3);
        
        System.out.println("c1 和 c2 相等嗎? " + c1.equals(c2));
        System.out.println("c1 和 c3 相等嗎? " + c1.equals(c3));
        System.out.println("c2 和 c3 相等嗎? " + c2.equals(c3));
    }
}