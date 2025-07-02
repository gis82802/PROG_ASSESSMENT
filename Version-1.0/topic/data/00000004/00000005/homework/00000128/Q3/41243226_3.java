import java.util.Scanner;
public class Mm {
    public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	System.out.println("輸入欲比較之a,b,c");
	double a=sc.nextDouble();
	double b=sc.nextDouble();
	double c=sc.nextDouble();//要求使用者輸入欲比較之三數
	double Max=(a>b)?a:b;
	Max=(Max>c)?Max:c;//比較出最大數
	double min=(a<b)?a:b;
	min=(min<c)?min:c;//比較出最小數
	Boolean TFa=(a==Max||a==min)?false:true;
	Boolean TFb=(b==Max||b==min)?false:true;
	Boolean TFc=(c==Max||c==min)?false:true;
	double md=(TFa)?a:(TFb)?b:(TFc)?c:0;//刪去法找出中間數
	System.out.println("最大值:"+Max+"中間值"+md+"最小值"+min);//輸出
    }
}
