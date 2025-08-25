import java.util.Scanner;

// 抽象父類別 CShape
abstract class CShape {
    public abstract void show();
}

// 子類別 CCircle
class CCircle extends CShape {
    private double radius;

    public CCircle(double radius) {
        this.radius = radius;
    }

    // 實作 show() 方法
    @Override
    public void show() {
        System.out.println("半徑=" + this.radius);
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 建立 CShape 型別的陣列，可以存放其子類別的物件
        CShape shp[] = new CShape[5];
        
        System.out.println("請輸入 5 個數字作為圓的半徑 (以空格分隔):");
        
        // 讀取輸入並建立 CCircle 物件
        for (int i = 0; i < 5; i++) {
            double radius = scanner.nextDouble();
            shp[i] = new CCircle(radius);
        }
        
        scanner.close();

        // 遍歷陣列並呼叫 show() 方法
        for (int i = 0; i < 5; i++) {
            shp[i].show();
        }
    }
}