import java.util.Scanner;
public class app4_2
{
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
	float f_m,f_x,f_y,f_MHT;	//f_m斜率、f_x有關x的計算、f_y有關y的計算、f_MHT曼哈頓
	double dV_dot,dD_a,dD_b;	//dV_dot向量內積、dD_a向量a長度、dD_b向量b長度
        double f_O,f_Cos;		//f_O歐式距離、f_Cos Cos計算值
	float fPa_x,fPb_x,fPa_y,fPb_y;	//fPa_x 點Pa的x、fPb_x點Pb的x、fPa_y點Pa的y、fPb_y點Pb的y
	//輸入初值
        System.out.print("請輸入Pa(x,y)的x值:");
	fPa_x=sc.nextFloat();
        System.out.print("請輸入Pa(x,y)的y值:");
	fPa_y=sc.nextFloat();
        System.out.print("請輸入Pb(x,y)的x值:");
	fPb_x=sc.nextFloat();
        System.out.print("請輸入Pb(x,y)的y值:");
	fPb_y=sc.nextFloat();
	//計算斜率，判斷是否垂直
        if(fPa_x-fPb_x!=0 && fPa_y-fPb_y!=0)
        {
	    f_m=(fPa_y-fPb_y)/(fPa_x-fPb_x);
	    //直線方程式
	    System.out.println("直線方程式:x+("+(-fPa_x)+")/"+ (fPb_x-fPa_x)+" = y+("+(-fPa_y)+")/"+(fPb_y-fPa_y));
        }
        else
        {
             if(fPa_x-fPb_x==0)
                 System.out.println("直線方程式:x="+fPa_x);
             else
                 System.out.println("直線方程式:y="+fPa_y);
        }
	//歐式距離
	float fD_1,fD_2;                //fD_1 Pa長度,fD_2 Pb長度
	fD_1=fPa_x-fPb_x;
	fD_2=fPa_y-fPb_y;
	f_O=Math.sqrt(Math.pow(fD_1,2)+Math.pow(fD_2,2));
	System.out.println("歐式距離:"+f_O);

	//曼哈頓距離
	f_x=Math.abs(fPa_x-fPb_x);
	f_y=Math.abs(fPa_y-fPb_y);
	f_MHT=f_x+f_y;
	System.out.println("曼哈頓距離:"+f_MHT);

	//切比登夫
	f_x=Math.abs(fPa_x-fPb_x);
	f_y=Math.abs(fPa_y-fPb_y);
	System.out.println("Max("+f_x+","+f_y+")");

	//向量夾角
	dV_dot=fPa_x*fPb_x+fPa_y*fPb_y;
	dD_a=Math.sqrt(Math.pow(fPa_x,2)+Math.pow(fPa_y,2));
	dD_b=Math.sqrt(Math.pow(fPb_x,2)+Math.pow(fPb_y,2));
	f_Cos=dV_dot/(dD_a*dD_b);
	System.out.println("夾角為 "+Math.toDegrees(Math.acos(f_Cos))+"度");
    }
}