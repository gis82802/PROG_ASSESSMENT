import java.util.Scanner;
class hw10253b{
	public static float[][] A(float[][] matrix){
		float x=matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
		x=1/x;
		float a=matrix[0][0];
		matrix[0][0]=matrix[1][1];
		matrix[1][1]=a;
		matrix[0][1]=matrix[0][1]*-1;
		matrix[1][0]=matrix[1][0]*-1;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				matrix[i][j]=matrix[i][j]*x;
			}
		}
		return matrix;
	}
	public static void main(String[] atgs){
		Scanner sc = new Scanner(System.in);
		float[][] matrix = new float[2][2];
		System.out.println("請輸入矩陣內數值(2x2矩陣)：");
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				System.out.print("Matrix["+i+"]["+j+"]=");
				matrix[i][j]=sc.nextFloat();
			}
		}
		float[][] matrix1 = A(matrix);
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
}