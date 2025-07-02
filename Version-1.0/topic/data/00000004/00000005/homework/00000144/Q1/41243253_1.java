import java.util.Scanner;
public class hw1
{
   public static void main(String args[])
   {
        Scanner scanner = new Scanner(System.in);                    //此程式區塊為讓使用者輸入兩個二維資料點，分別為(x1,y1)以及(x2,y2)
	System.out.println("請輸入x1的值:");
	int x1 = scanner.nextInt();
	System.out.println("請輸入x2的值:");
	int x2 = scanner.nextInt();
	System.out.println("請輸入y1的值:");
	int y1 = scanner.nextInt();
	System.out.println("請輸入y2的值:");
	int y2 = scanner.nextInt();
	
	//二點直線方程式
	int m;								
	m=(y2-y1)/(x2-x1);        //計算斜率
	int coex1=(-x1*m)+y1;
	System.out.println("二點直線方程式為：y="+m+"x+"+coex1);    

	//歐式距離
	double ED = Math.sqrt(Math.pow(x1-x2,2.0)+Math.pow(y1-y2,2.0));
	System.out.println("二點的歐式距離為："+ED);

	//曼哈頓距離
	int absdata1=Math.abs(x1-x2);		//absdata1為第一個二維資料點中的x1與第二個二維資料點中的x2做相減後取絕對值
	int absdata2=Math.abs(y1-y2);           //absdata2為第一個二維資料點中的y1與第二個二維資料點中的y2做相減後取絕對值
	System.out.println("曼哈頓距離為："+(absdata1+absdata2));   

	//切比雪夫
	System.out.println("切比雪夫 Max("+absdata1+","+absdata2+")");
	if(absdata1>absdata2)
	{
	     
	     System.out.println("切比雪夫距離為："+absdata1);
	}
	else
	     System.out.println("切比雪夫距離為："+absdata2);

	//向量角度 
	double DP = (x1 * x2) + (y1 * y2); 	// 點積
        double m1 = Math.sqrt(Math.pow(x1, 2.0) + Math.pow(y1, 2.0)); // 向量1的長度
        double m2 = Math.sqrt(Math.pow(x2, 2.0) + Math.pow(y2, 2.0)); // 向量2的長度

        if (m1 == 0 || m2 == 0) {
            System.out.println("向量的長度為零，無法計算夾角");
        } else {
            // 計算cosθ並夾住範圍在-1到1之間
            double cosTheta = DP / (m1 * m2);
            cosTheta = Math.max(-1.0, Math.min(1.0, cosTheta));

            // 計算夾角並轉換為度數
            double angle = Math.toDegrees(Math.acos(cosTheta));
            System.out.println("二個向量的夾角為：" + angle + " 度");
        }


   }
}