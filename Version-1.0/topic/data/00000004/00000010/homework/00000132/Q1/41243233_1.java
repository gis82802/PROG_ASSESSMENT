public class hw17{
	public static void main(String args[]){
		int[][] a1={{1,2,3},{4,5,6}},		//3x2
			a2={{7,8},{9,10},{11,12}};	//2x3

		System.out.print("a1={");
		for(int i=0;i<a1.length;i++){
			System.out.print("{");
			for(int j=0;j<a1[0].length;j++){
				System.out.print(a1[i][j]);
				if(j!=(a1[0].length-1))
					System.out.print(",");
			}
			if(i!=(a1.length-1))
				System.out.print("},");
		}
		System.out.println("}}");
		
		System.out.print("a2={");
		for(int i=0;i<a2.length;i++){
			System.out.print("{");
			for(int j=0;j<a2[0].length;j++){
				System.out.print(a2[i][j]);
				if(j!=(a2[0].length-1))
					System.out.print(",");
			}
			if(i!=(a2.length-1))
				System.out.print("},");
		}
		System.out.println("}}");
		
		int[][] a3 = MatMultiply(a1, a2);
		System.out.print("a3={");
		for(int i=0;i<a3.length;i++){
			System.out.print("{");
			for(int j=0;j<a3[0].length;j++){
				System.out.print(a3[i][j]);
				if(j!=(a3[0].length-1))
					System.out.print(",");
			}
			if(i!=(a3.length-1))
				System.out.print("},");
		}
		System.out.print("}}");
		
	}
	public static int[][] MatMultiply(int [][] b1,int [][] b2){

		if (b1[0].length != b2.length)
        		return null;

		int[][] b3 = new int[b1.length][b2[0].length];

		for(int i=0;i<b1.length;i++)
			for(int j=0;j<b2[0].length;j++)
				for(int k=0;k<b1[0].length;k++)
					b3[i][j] += b1[i][k] * b2[k][j];
		return b3;
	}
	
}