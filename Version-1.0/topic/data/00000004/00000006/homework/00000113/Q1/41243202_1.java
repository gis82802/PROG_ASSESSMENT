/*
	作業一：圓周率
	資工二乙	41243202	林沛慧
	功能1：一開始將輸出經過每一萬次計算算出的圓周率，直到十萬
	功能2：一直重複計算直到圓周率的值是3.14159
*/
public class w1
{
	public static void main(String[] args)
	{
		float x = 0,x1=0,x2=0;
		for(int k=1;k<=10;k++)	//用來改變i值上限
		{	
			for(float i=1;i<=10000*k;i+=2)
			{
				//公式部分
				x1=2*i-1;
				x2=2*i+1;
				x+=(float)1/x1;	//用float讓其有小數點
				x-=(float)1/x2;
			}
			System.out.println("當i = "+10000*k+" ,pi值 = "+4*x);
			x = 0;	//重設初始值
		}
		float s=1;
		while(x!=3.14159)  //如果結果不是3.14159則一直計算
		{
			x1=2*s-1;
			x2=2*s+1;
			x+=(float)1/x1;
			x-=(float)1/x2;
			if (Math.abs(x * 4 - 3.14159) < 0.00001)
			{
				x=x*4;
			}
			s++;
		}
		System.out.println("若要算到"+s);
		
	}
}