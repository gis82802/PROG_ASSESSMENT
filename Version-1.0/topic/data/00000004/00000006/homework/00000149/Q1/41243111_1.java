public class Test1
{
	public static void main(String args[])
	{
		
		//=========計算i=10000到100000的pi值
		
		int i,maxi;
		float pi;
		
		for(maxi=10000; maxi<=100000; maxi+=10000)
		{
			pi=0;
			
			for(i=1; i<=maxi; i++)
			{
				if(i%2!=0)
					pi+=1.0/(2*i-1);
				else
					pi-=1.0/(2*i-1);
			}
			
			System.out.printf("當i值到達 %-7d時pi= %.10f\n",maxi,4*pi);
			
		}
		
		//=========計算要得到pi=3.14159的i最小值(容忍誤差值為0.000009即只要求準確計算出小數點後5位數)
		
		pi=0;
		i=1;
		
		while(true)
		{
			if(i%2!=0){
				pi+=1.0/(2*i-1);
			}
			else{
				pi-=1.0/(2*i-1);
			}
			i++;
			
			if (4*pi-3.14159<0.000009&&4*pi>3.14159){  //計算值-目標值<容忍誤差值 AND pi值大於目標值 
				break;
			}	

		}
		
		System.out.printf("\n當i值到達 %d 時可得到pi= %.6f\n",i,4*pi);
		
	}
}