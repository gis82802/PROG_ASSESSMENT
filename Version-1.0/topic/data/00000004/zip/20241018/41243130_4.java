//1018上課練習_4
import java.util.Scanner;
public class a1018_4
{
	public static void main(String arg[])
	{
		Scanner scn=new Scanner(System.in);
		System.out.print("請輸入陣列大小n:");
		int input=scn.nextInt();
		int arr[][]=new int[input][input],arr1[][]=new int[input-1][input-1];
		System.out.print("請輸入陣列內容:");
		for(int i=0;i<input;i++)
		{
			for(int j=0;j<input;j++)
			{
				arr[i][j]=scn.nextInt();
			}
		}
		System.out.println("輸入陣列內容為");
		for(int i=0;i<input;i++)
		{
			for(int j=0;j<input;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.print("請輸入刪除的i及j:");
		int D_i=scn.nextInt(),D_j=scn.nextInt();
		for(int i=0;i<input;i++)
		{
			for(int j=0;j<input;j++)
			{
				if(i!=D_i-1&&j!=D_j-1)
				{
					System.out.print(arr[i][j]+" ");
				}
			}
			if(i!=D_i-1)
				System.out.println();
		}
		 int newRow = 0, newCol;

        for (int i = 0; i < input; i++) {
            if (i == D_i-1) continue;  // 跳過要刪除的列
            newCol = 0;
            for (int j = 0; j < input; j++) {
                if (j == D_j-1) continue;  // 跳過要刪除的行
                arr1[newRow][newCol] = arr[i][j];
                newCol++;
            }
            newRow++;
        }
		int num=0;
		switch(input)
		{
			case 1:
				break;
			case 2:
				num=arr1[0][0];
				break;
			case 3:
				num = arr1[0][0] * arr1[1][1] - arr1[0][1] * arr1[1][0];
				break;
			case 4:
				int a = arr1[0][0], b = arr1[0][1], c = arr1[0][2];
				int d = arr1[1][0], e = arr1[1][1], f = arr1[1][2];
				int g = arr1[2][0], h = arr1[2][1], i = arr1[2][2];
				num =	    a * e * i 
						  + a * f * h 
                          + b * d * i 
                          - c * e * g 
                          - c * d * h 
                          - b * f * g;
				break;
		}
		System.out.println("新的行列式為:"+num);
	}
}