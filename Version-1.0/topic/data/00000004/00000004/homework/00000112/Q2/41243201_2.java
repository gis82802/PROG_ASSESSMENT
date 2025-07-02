public class hw2{
	public static void main(String[] args)
	{
		String[] nfu={"國","立","虎","尾","科","技","大","學"};
		String[] name={"吳","佳","璇"};
		int[] uni_nfu={'國','立','虎','尾','科','技','大','學'};
		int[] uni_name={'吳','佳','璇'};
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