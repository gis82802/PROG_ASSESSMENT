import java.util.Scanner;

public class hw3b_1025{
   public static void main(String[] args){
      Scanner scn=new Scanner(System.in);
      float[][] a = new float[2][2];
      float[][] b = new float[2][2];
      float[][] c1 = new float[2][2];
      float[][] c2 = new float[2][2];
      int k = 1;
      System.out.println("輸入A矩陣值:");
      for(int i=0;i<2;i++){
         for(int j=0;j<2;j++){
            a[i][j]=scn.nextInt();
         }
      }
      b = invMatrix(a);

      c1 = MatMultiply(a,b);				
      c2 = MatMultiply(b,a);

      for (int i = 0; i < 2; i++) {			//判斷2個相乘後的矩陣是否相等
         for (int j = 0; j < 2; j++) {
            if (c1[i][j] != c2[i][j]) {
               k = 0;
            }
         }
      }

      if(a[0][0] != 1 && a[0][1] != 0 && a[1][0] != 0 && a[1][1] != 1){		//判斷是否為單位矩陣
         k = 0;
      }
      if(k == 1){
         System.out.println("反矩陣為:");
         for(int i=0;i<2;i++){
	    for(int j=0;j<2;j++){
	       System.out.print(b[i][j]+"  ");
	    }
	    System.out.print("\n");
         }
      }
      else{
         System.out.println("反矩陣計算錯誤");
      }
   }

/*			計算反矩陣					*/

   public static float[][] invMatrix(float[][] x){
      float[][] y=new float[2][2];
      float n;
      for(int i=0;i<2;i++){				//將x的值給y
	    for(int j=0;j<2;j++){
	       y[i][j]=x[i][j];
	    }
      }
      n = 1 / (x[0][0]*x[1][1] - x[0][1]*x[1][0]);	
      y[0][0] = n * x[1][1];
      y[0][1] = n * x[0][1] * -1;
      y[1][0] = n * x[1][0] * -1;
      y[1][1] = n * x[0][0];
      return y;
   }

/*			2個矩陣相乘					*/

   public static float[][] MatMultiply(float[][] b1,float[][] b2){
      float k[][]=new float[2][2];
      for(int i=0;i<2;i++){
         for(int j=0;j<2;j++){
	    int sum=0;
	    for(int l=0;l<2;l++){
	       sum+=b1[i][l]*b2[l][j];
	    }	
	    k[i][j]=sum;
	 }	 
      }
      return k;
   }


}

