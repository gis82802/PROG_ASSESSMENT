import java.util.Scanner;
 public class owoblue_java07
 {
  public static void main(String args[])
   {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入第一個點的 x, y 座標 (以空格分隔):");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("請輸入第二個點的 x, y 座標 (以空格分隔):");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double s=(y2-y1)/(x2-x1);
        double i=y1-s*x1;
        System.out.println("直線方程式為:y="+s+"x+"+i);
        System.out.println("歐式距離為:"+Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
        System.out.println("曼哈頓距離為:"+(Math.abs(x2 - x1)+Math.abs(y2 - y1)));
        System.out.println("切比雪夫距離為:"+(Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1))));
        double d = x1 * x2 + y1 * y2;
        double m1 = Math.sqrt(x1 * x1 + y1 * y1);
        double m2 = Math.sqrt(x2 * x2 + y2 * y2);
        System.out.println("兩向量的夾角為:"+Math.acos(d / (m1 * m2)));

        System.out.println("請輸入直線方程式的係數 A, B, C (直線方程式: Ax + By + C = 0，以空格分隔):");
        double A = sc.nextDouble();
        double B = sc.nextDouble();
        double C = sc.nextDouble();

        System.out.println("請輸入點的座標 (x, y) 以空格分隔:");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.println("點到直線的距離為:"+(Math.abs(A * x + B * y + C) / Math.sqrt(A * A + B * B)));
		
		System.out.println("請輸入三個數字 (以空格分隔):");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();


        int max = Math.max(num1, Math.max(num2, num3));
        int min = Math.min(num1, Math.min(num2, num3));

        int sum = num1 + num2 + num3;
        int mid = sum - max - min;

        System.out.printf("最小:"+min+"中間:"+mid+"最大:"+max);
   }
 }