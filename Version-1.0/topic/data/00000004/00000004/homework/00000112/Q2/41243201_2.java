public class hw2{
	public static void main(String[] args)
	{
		String[] nfu={"��","��","��","��","��","��","�j","��"};
		String[] name={"�d","��","�"};
		int[] uni_nfu={'��','��','��','��','��','��','�j','��'};
		int[] uni_name={'�d','��','�'};
		for(int i=0;i<=7;i++)
		{
			System.out.print(nfu[i]+"("+uni_nfu[i]+")"+"\n");
		}
		for(int i=0;i<=2;i++)
		{
			System.out.print(name[i]+"("+uni_name[i]+")"+"\n");
		}
	}
}