import java.util.Scanner;

public class owoblue_java11 {
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入一維陣列的內數字(陣列大小為10):");
		int[] arg1=new int[10];
        for(int i=0;i<10;i++){arg1[i]=scanner.nextInt();}
	    int num=arg1[0];
        System.out.print("陣列排序前:");
        for(int i=0;i<10;i++){System.out.printf("%d ",arg1[i]);}
	    for(int i=0;i<9;i++)
	    {
			for(int j=i+1;j<10;j++)
			{
				if(arg1[i]<arg1[j])
				{
				 num=arg1[i];
				 arg1[i]=arg1[j];
				 arg1[j]=num;
				}
			}
	    }
		System.out.print("\n陣列排序後:");
		for(int i=0;i<10;i++){System.out.printf("%d ",arg1[i]);}
		System.out.println("\n請輸入一維陣列的內數字(陣列大小為10):");
		int[] arg2=new int[10];
		int[] arg3=new int[10];
		int[] arg4=new int[10];
        for(int i=0;i<10;i++){arg2[i]=scanner.nextInt();}
		for(int i=0;i<10;i++)
		{
		arg3[i]=arg2[i];
		arg4[i]=arg2[i];
		}
		for(int i=0;i<9;i++)
		{
			for(int j=i+1;j<10;j++)
			{
				if(arg3[i]<arg3[j])
				{
				arg3[i]=arg3[j];
				}
			}
		}
		arg3[9]=-1;
		System.out.print("\n陣列各元素後最大值替代(最後一項為-1):");
		for(int i=0;i<10;i++){System.out.printf("%d ",arg3[i]);}
		System.out.print("\n");
		for(int i=0;i<10;i++){System.out.printf("%d ",arg2[i]);}
		for(int i=0;i<9;i++)
		{
			for(int j=i+1;j<10;j++)
			{
				if(arg4[i]>arg4[j])
				{
				arg4[i]=arg4[j];
				}
			}
		}
		arg4[9]=-1;
		System.out.print("\n陣列各元素後最小值替代(最後一項為-1):");
		for(int i=0;i<10;i++){System.out.printf("%d ",arg4[i]);}
    }
}
 
