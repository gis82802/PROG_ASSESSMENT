import java.util.Scanner;

public class hw3a_1025{
   public static void main(String[] args){
      Scanner scn=new Scanner(System.in);
      int n=0,m=0,x=0,y=0;
      int[][] a1;
      int[][] a2;
      int[][] o;
      System.out.print("輸入A矩陣的列: ");
      n = scn.nextInt();
      System.out.print("輸入A矩陣的行: ");
      m = scn.nextInt();
      a1=new int[n][m];
      System.out.println("輸入A矩陣值");	
      for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
         a1[i][j]=scn.nextInt();
         }
      }
      System.out.print("輸入B矩陣的列: ");
      x = scn.nextInt();
      System.out.print("輸入B矩陣的行: ");
      y = scn.nextInt();
      a2=new int[x][y];
      System.out.println("輸入B矩陣值");	
      for(int i=0;i<x;i++){
         for(int j=0;j<y;j++){
         a2[i][j]=scn.nextInt();
         }
      }
   System.out.println("A矩陣:");
   for(int i=0;i<a1.length;i++){
      for(int j=0;j<a1[i].length;j++){
          System.out.print(a1[i][j]+"  ");
      }
      System.out.print("\n");
   }
   System.out.println("B矩陣:");
   for(int i=0;i<a2.length;i++){
      for(int j=0;j<a2[i].length;j++){
          System.out.print(a2[i][j]+"  ");
      }
      System.out.print("\n");
   }
   
   o=MatMultiply(a1,a2);
   
   if(o == null){
	 System.out.println("無法相乘");
         return ;
   }else{
   System.out.println("兩矩陣相乘結果: ");
      for(int i=0;i<o.length;i++){
	    for(int j=0;j<o[i].length;j++){
	       System.out.print(o[i][j]+"  ");
	    }
	    System.out.print("\n");
         }
      }
   }

   public static int[][] MatMultiply(int[][] b1,int[][] b2){
      int k[][]=new int[b1.length][b2[0].length];
         if (b1[0].length != b2.length) {		//判斷2矩陣是否能相乘
            return null;
         }
         for(int i=0;i<b1.length;i++){
	    for(int j=0;j<b2[0].length;j++){
	       int sum=0;
	       for(int l=0;l<b1[0].length;l++){
	          sum+=b1[i][l]*b2[l][j];
	       }	
	       k[i][j]=sum;
	    }	 
         }
      return k;
   }
}

