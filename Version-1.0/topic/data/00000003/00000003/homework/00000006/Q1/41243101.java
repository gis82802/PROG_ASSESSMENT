public class hw
{
	public static void main(String[] args)
	{
		int A[][]={{1,2,3},{4,5,6}};
		int B[][]={{1,2},{3,4},{5,6}};	
		int C[][];
		C=MatMultiply(A,B);
		System.out.println("A陣列內容:");
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<A[i].length;j++)
			{
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("B陣列內容:");
		for(int i=0;i<B.length;i++)
		{
			for(int j=0;j<B[i].length;j++)
			{
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("兩矩陣相乘的結果=");
		for(int i=0;i<C.length;i++)
		{
			for(int j=0;j<C[i].length;j++)
			{
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();

		//A的逆矩陣
		if(A.length==A[0].length&&A.length==2)
		{
			double[][] invA= invMatrix(A);
			if (invA!= null) 
			{
				//驗證A*invA是否為單位矩陣
				double D[][]=MatMultiply(A,invA);
				System.out.println("A * A的逆矩陣:");
            			for (int i = 0; i < D.length; i++)
				{
              	 			for (int j = 0; j < D[i].length; j++)
					{
                   				 System.out.printf("%.2f ", D[i][j]);
                			}
               				System.out.println();
        			} 
				System.out.println();
				boolean isIdentity = true;
				for (int i = 0; i < D.length; i++)
				{
    					for (int j = 0; j < D[i].length; j++)
					{
						 // 左上至右下對角線位置數值應為 1 // 右上至左下非對角線位置數值應為 0
       						 if ((i == j && D[i][j]!=1)||(i != j && D[i][j]!=0))    
						 {
            						isIdentity = false;
            						break;
       						 }
   					}
    					if (!isIdentity) break;
				}
				if (isIdentity)
				{
					System.out.println("A 的逆矩陣:");
    					for (int i = 0; i < invA.length; i++) 
					{
       						 for (int j = 0; j < invA[i].length; j++)
						 {
            						System.out.printf("%.2f ", invA[i][j]);
        					 }
        					System.out.println();
					}
				}
				else
				{
					System.out.println("此逆矩陣有誤");
				}
               		}
			else
				System.out.println("此矩陣不可逆"); 
		}
		else
			System.out.println("此矩陣非2X2方陣");	
	}

	//計算兩矩陣相乘 (int 和 int)
	public static int[][] MatMultiply(int arr [][],int arr2 [][])
	{	
		int product[][]=new int[arr.length][arr2[0].length];
		if(arr[0].length!=arr2.length)
		{
			return null;
		}
		else
		{
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr2[0].length;j++)
				{
					for(int k=0;k<arr[0].length;k++)
					{
						product[i][j]+=arr[i][k]*arr2[k][j];
					}
				}	
			}
			return product;
		}
	}
	// 計算兩矩陣相乘 (int 和 double)
    	public static double[][] MatMultiply(int[][] arr, double[][] arr2)
	{
        	double[][] product = new double[arr.length][arr2[0].length];
        	if (arr[0].length != arr2.length)
		{
            		return null;
        	} 
		else 
		{
        		for (int i = 0; i < arr.length; i++) 
			{
                		for (int j = 0; j < arr2[0].length; j++) 
				{
                    			for (int k = 0; k < arr[0].length; k++)
					{
                        			product[i][j] += arr[i][k] * arr2[k][j];
                    			}
                		}
            		}
            		return product;
        	}
    	}
	
	//計算逆矩陣
	public static double[][] invMatrix(int matrix [][])
	{	
		int a = matrix[0][0];
       		int b = matrix[0][1];
        	int c = matrix[1][0];
       		int d = matrix[1][1];
        
        	double determinant = a * d - b * c; //行列式

       		if (determinant == 0) 
		{
            		return null; //不可逆
        	}

        	double[][] inverse ={{d / determinant, -b / determinant},{-c / determinant, a / determinant}};//計算逆矩陣
		return inverse;
	}
}