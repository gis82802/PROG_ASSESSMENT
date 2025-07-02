// a0927_1
public class a0927_1
{
	public static void main(String arg[])
	{
		int a,a1,a2;int[] nfu={'國','立','虎','尾','科','技','大','學'};
		a='張';
		a1='凱';
		a2='茗';
		System.out.print(""+(char)a+"("+a+")"+(char)a1+"("+a1+")"+(char)a2+"("+a2+")"+"\n");
		for(int i=0;i<8;i++)
		{
			System.out.print(""+(char)nfu[i]+"("+nfu[i]+")");
		}System.out.println();
	}
}