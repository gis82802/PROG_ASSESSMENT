import java.util.Scanner;

abstract class CShape {
    public abstract double area();

    public static void largest(CShape[] shapes) {
        if (shapes.length == 0) {
            System.out.println("陣列為空，無法計算。");
            return;
        }

        double maxArea = 0;
        for (CShape shape : shapes) {
            double currentArea = shape.area();
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        System.out.println("最大物件的面積: " + maxArea);
    }
}

class CCircle extends CShape {
    private double radius;

    public CCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class CSquare extends CShape {
    private double side;

    public CSquare(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class CTriangle extends CShape {
    private double base;
    private double height;

    public CTriangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("請依序輸入 CCircle 半徑, CCircle 半徑, CSquare 邊長, CTriangle 底邊, CTriangle 高, CTriangle 底邊, CTriangle 高 (以空格分隔):");
        
        CShape shp[] = new CShape[5];
        shp[0] = new CCircle(scanner.nextDouble());
        shp[1] = new CCircle(scanner.nextDouble());
        shp[2] = new CSquare(scanner.nextDouble());
        shp[3] = new CTriangle(scanner.nextDouble(), scanner.nextDouble());
        shp[4] = new CTriangle(scanner.nextDouble(), scanner.nextDouble());
        
        scanner.close();

        CShape.largest(shp);
    }
}